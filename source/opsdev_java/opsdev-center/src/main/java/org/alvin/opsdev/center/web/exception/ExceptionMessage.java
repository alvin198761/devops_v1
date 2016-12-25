package org.alvin.opsdev.center.web.exception;

import java.util.List;

/**
 * Created by tangzhichao on 2016/11/3.
 */
public class ExceptionMessage {

    private Integer code;
    private String message;
    private List<Object> detail;

    public ExceptionMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ExceptionMessage(Integer code, String message, List<Object> detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getDetail() {
        return detail;
    }

    public void setDetail(List<Object> detail) {
        this.detail = detail;
    }
}
