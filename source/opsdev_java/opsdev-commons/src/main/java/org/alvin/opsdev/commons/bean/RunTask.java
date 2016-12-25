package org.alvin.opsdev.commons.bean;


import org.alvin.opsdev.commons.bean.enums.TaskStatus;

/**
 * Created by tangzhichao on 2016/12/9.
 */
public class RunTask {

    private Integer id;
    private TaskStatus status;
    private Integer exitCode;
    private String success;
    private String error;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Integer getExitCode() {
        return exitCode;
    }

    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
