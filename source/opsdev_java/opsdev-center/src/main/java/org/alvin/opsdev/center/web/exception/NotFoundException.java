package org.alvin.opsdev.center.web.exception;

import java.util.List;

/**
 * Created by tangzhichao on 2016/11/3.
 */
public class NotFoundException extends WebAppException implements ErrorCode {

    public NotFoundException(String message) {
        super(NOT_FOUND, message);
    }

    public NotFoundException(String message, List<Object> detail) {
        super(NOT_FOUND, message, detail);
    }
}
