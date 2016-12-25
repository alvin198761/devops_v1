package org.alvin.opsdev.center.web.exception;

import java.util.List;

/**
 * Created by tangzhichao on 2016/11/3.
 */

public class WebAppException extends RuntimeException {

    private ExceptionMessage exceptionMessage;

    public WebAppException(int code, String message) {
        setExceptionMessage(new ExceptionMessage(code, message));
    }

    public WebAppException(int code, String message, List<Object> detail) {
        setExceptionMessage(new ExceptionMessage(code, message, detail));
    }


    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
