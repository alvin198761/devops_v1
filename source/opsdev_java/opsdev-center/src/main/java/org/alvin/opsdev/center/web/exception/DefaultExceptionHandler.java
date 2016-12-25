package org.alvin.opsdev.center.web.exception;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by tangzhichao on 2016/11/3.
 */
@ControllerAdvice
public class DefaultExceptionHandler implements ErrorCode {

    private Logger logger = Logger.getLogger(DefaultExceptionHandler.class);
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionMessage processException(Locale locale, Exception ex) {
        logger.error(ex);
        return new ExceptionMessage(UNKNOWN, ex.getMessage());
    }

    @ExceptionHandler({WebAppException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ExceptionMessage processCustomException(Locale locale, WebAppException ex) {
        logger.error(ex);
        return ex.getExceptionMessage();
    }

}
