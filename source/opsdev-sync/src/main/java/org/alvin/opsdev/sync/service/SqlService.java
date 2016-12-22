package org.alvin.opsdev.sync.service;

import com.google.common.base.Joiner;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by tangzhichao on 2016/12/20.
 */
public class SqlService {

    public String createInsertSql(String table, List<String> cols ) {
        String format = "insert into {0} ({1}) values ({2})";
        String colsStr = Joiner.on(",").skipNulls().join(cols);
        String flags = Joiner.on(",").skipNulls().join(cols.stream().map(item -> "?").collect(Collectors.toList()));
        return MessageFormat.format(format, table, colsStr, flags);
    }

    public String createUpdateSql(String table, List<String> cols ,String where) {
        String sql = "update {0} set {1} where {2}";
        String colsStr = Joiner.on(",").skipNulls().join(cols.stream().map(item -> item += "=?").collect(Collectors.toList()));
        return MessageFormat.format(sql, table, colsStr ,where);
    }

    public String createReadSql(Map<String, List<String>> colsMap, String where) {
        String sql = "select {0} from {1} " + where;
        String table = Joiner.on(",").skipNulls().join(colsMap.keySet().stream().map(item ->
                item + " as _" + item + "_"
        ).collect(Collectors.toList()));
        StringBuffer buffer = new StringBuffer();
        colsMap.forEach((key, value) -> {
            String t = "_" + key + "_.";
            value.stream().forEach(item -> {
                if (buffer.length() != 0) {
                    buffer.append(",");
                }
                buffer.append(t).append(item);
            });
        });
        return MessageFormat.format(sql, buffer.toString(), table);
    }

}
