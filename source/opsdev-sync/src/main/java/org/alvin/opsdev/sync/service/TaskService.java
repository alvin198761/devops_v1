package org.alvin.opsdev.sync.service;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;
import com.google.gson.Gson;
import org.alvin.opsdev.sync.bean.Column;
import org.alvin.opsdev.sync.bean.Table;
import org.alvin.opsdev.sync.bean.Task;
import org.alvin.opsdev.sync.dao.SpringJDBCTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by tangzhichao on 2016/12/20.
 */
public class TaskService {

    private ExecutorService threadPool = Executors.newFixedThreadPool(2);

    private SqlService sqlService = new SqlService();

    private List<Future> futures = Lists.newArrayList();


    public void sync(Path path) {
        System.out.println("sync file:" + path.toString());
        try {
            Task task = new Gson().fromJson(Files.newBufferedReader(path), Task.class);
            futures.add(threadPool.submit(() -> exec(task)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exec(Task task) {
        SpringJDBCTemplate sourceTemplate = new SpringJDBCTemplate(task.getSource());
        SpringJDBCTemplate targetTemplate = new SpringJDBCTemplate(task.getTarget());
        task.getSync().forEach(t -> {
            //先删除
            delete(sourceTemplate, targetTemplate, t);
            //然后更新
            update(sourceTemplate, targetTemplate, t);
            //最后新增
            doInsert(sourceTemplate, targetTemplate, t);
        });
    }

    private void delete(SpringJDBCTemplate sourceTemplate, SpringJDBCTemplate targetTemplate, Table table) {
        System.out.println("do delete table :" + table.getName());
        //获取主键列
        Column column = table.getCols().stream().filter(c -> c.getKey() != null && c.getKey()).findFirst().get();
        //去源头数据处，获取所有的主键列
        List<Object> targetKeys = sourceTemplate.queryForList("select " + column.getSource() + " from " +column.getTable(), Object.class);
        if (!targetKeys.isEmpty()) {
            String ids = Joiner.on(",").skipNulls().join(targetKeys);
            targetTemplate.batchUpdate("delete from " + table.getName() + " where " + column.getTarget() + " not in(" + ids + ")");
        }
    }

    private void update(SpringJDBCTemplate sourceTemplate, SpringJDBCTemplate targetTemplate, Table table) {
        System.out.println("updata table :" + table.getName());
        List<String> targetCols = table.getCols().stream().map(col -> col.getTarget()).collect(Collectors.toList());
        List<String> sourceCols = table.getCols().stream().map(col -> col.getSource()).collect(Collectors.toList());
        //获取主键列
        Column column = table.getCols().stream().filter(c -> c.getKey() != null && c.getKey()).findFirst().get();
        //获取需要更新的数据列
        List<Object> targetKeys = targetTemplate.queryForList("select " + column.getTarget() + " from " + table.getName(), Object.class);
        if(targetKeys.isEmpty()){
            return ;
        }
        //这几是要得到所有需要查询的表和对应的列
        Map<String, List<String>> sourceTableMpa = new HashMap<>();
        table.getCols().forEach(item -> {
            if (!sourceTableMpa.containsKey(item.getTable())) {
                sourceTableMpa.put(item.getTable(), Lists.newArrayList());
            }
            sourceTableMpa.get(item.getTable()).add(item.getSource());
        });
        //查询更新的数据
        String ids = Joiner.on(",").skipNulls().join(targetKeys);
        String sql = sqlService.createReadSql(sourceTableMpa, " where " + column.getTarget() + " in (" + ids + ")");
        List<Map<String, Object>> sourceDataList = sourceTemplate.queryForList(sql);
        String where = column.getTarget() + "=?";
        String updateSql = sqlService.createUpdateSql(table.getName(), targetCols, where);
        //吧列的顺序调整好，拼接参数
        List<Object[]> params = sourceDataList.stream().map(item -> {
            Object[] array = new Object[sourceCols.size() + 1];
            int i = 0;
            for (String str : sourceCols) {
                array[i++] = item.get(str);
            }
            array[i] = item.get(column.getTarget());
            return array;
        }).collect(Collectors.toList());
        targetTemplate.batchUpdate(updateSql, params);
    }

    private void doInsert(SpringJDBCTemplate sourceTemplate, SpringJDBCTemplate targetTemplate, Table table) {
        System.out.println("insert table :" + table.getName());
        List<String> sourceCols = table.getCols().stream().map(col -> col.getSource()).collect(Collectors.toList());
        List<String> targetCols = table.getCols().stream().map(col -> col.getTarget()).collect(Collectors.toList());
        //获取主键列
        Column column = table.getCols().stream().filter(c -> c.getKey() != null && c.getKey()).findFirst().get();
        //获取需要更新的数据列
        List<Object> targetKeys = targetTemplate.queryForList("select " + column.getTarget() + " from " + table.getName(), Object.class);
        //这几是要得到所有需要查询的表和对应的列
        Map<String, List<String>> sourceTableMpa = new HashMap<>();
        table.getCols().forEach(item -> {
            if (!sourceTableMpa.containsKey(item.getTable())) {
                sourceTableMpa.put(item.getTable(), Lists.newArrayList());
            }
            sourceTableMpa.get(item.getTable()).add(item.getSource());
        });
        //查询添加的数据
        String notIn = "";
        if(!targetKeys.isEmpty()) {
            String ids = Joiner.on(",").skipNulls().join(targetKeys);
            notIn ="not in (" + ids + ")";
        }
        String sql = sqlService.createReadSql(sourceTableMpa, " where " + column.getTarget() +" " + notIn );
        List<Map<String, Object>> sourceDataList = sourceTemplate.queryForList(sql);
        String updateSql = sqlService.createInsertSql(table.getName(), targetCols );
        //吧列的顺序调整好，拼接参数
        List<Object[]> params = sourceDataList.stream().map(item -> {
            Object[] array = new Object[sourceCols.size()];
            int i = 0;
            for (String str : sourceCols) {
                array[i++] = item.get(str);
            }
            return array;
        }).collect(Collectors.toList());
        targetTemplate.batchUpdate(updateSql, params);
    }

    public void waitFor() {
        this.futures.forEach(item -> {
            try {
                item.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
