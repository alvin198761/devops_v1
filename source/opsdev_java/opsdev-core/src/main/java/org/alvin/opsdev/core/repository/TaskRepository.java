package org.alvin.opsdev.core.repository;

import org.alvin.opsdev.commons.bean.RunTask;
import org.alvin.opsdev.commons.bean.enums.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/10.
 */
@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<RunTask> taskMapper = (res, row) -> getRunTask(res);

    private ResultSetExtractor<RunTask> extractor = (res) -> getRunTask(res);

    private RunTask getRunTask(ResultSet res) throws SQLException {
        RunTask task = new RunTask();
        task.setId(res.getInt("id"));
        task.setStatus(TaskStatus.valueOf(res.getString("status")));
        task.setExitCode(res.getInt("code"));
        task.setSuccess(res.getString("success"));
        task.setError(res.getString("error"));
        return task;
    }


    public RunTask findOne(Integer id) {
        String sql = "select * from task where uuid=?";
        return jdbcTemplate.query(sql, new Object[]{id}, extractor);
    }

    public List<RunTask> findAll() {
        String sql = "select * from task";
        return jdbcTemplate.query(sql, new Object[0], taskMapper);
    }

    public int save(RunTask task) {
        String sql = "insert into task (`status`,`code`,`success`,`error`) values (?,?,?,?)";
        return jdbcTemplate.update(sql, new Object[]{
                task.getStatus().name(),
                task.getExitCode(),
                task.getSuccess(),
                task.getError()
        });
    }

    public int update(RunTask task) {
        String sql = "update task set status=? , code=? ,success=? ,error=? where id=?";
        return jdbcTemplate.update(sql, new Object[]{
                task.getStatus().name(),
                task.getExitCode(),
                task.getSuccess(),
                task.getError(),
                task.getId()
        });
    }

    public int delete(Integer id) {
        String sql = "delete from task where uuid=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }


}
