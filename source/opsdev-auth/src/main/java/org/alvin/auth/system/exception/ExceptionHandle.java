package org.alvin.auth.system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;

/**
 * Created by tangzhichao on 2016/12/8.
 */
@ControllerAdvice
public class ExceptionHandle {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionMessage processException(Locale locale, Exception ex) {
       // return new ExceptionMessage(ErrorCode.EGENERALEXCEPTION, messageSource.getMessage(String.valueOf(ErrorCode.EGENERALEXCEPTION), null, locale));
        return null;
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionMessage processParameterException(IllegalArgumentException ex,Locale locale) {
//        String msg = ex.getMessage() + (ex.getDetail()==null?"":":"+ Joiner.on(",").join(ex.getDetail()));
//        logger.warn(msg);
//        String frontMsg = messageSource.getMessage(String.valueOf(ex.getCode()),ex.getVars(),locale);
//        if(ex.getDetail() != null){
//            frontMsg = ex.getState().equals(ParameterException.PERMIT)?"[warn]"+frontMsg:"[error]"+frontMsg;
//        }
//        return new ExceptionMessage(ex.getCode(), frontMsg,ex.getDetail());
        return null;
    }

    @ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionMessage processBusinessException(Locale locale, ServiceException ex) {
//        logger.error(ex.getMessage());
//        return new ExceptionMessage(ex.getCode(), messageSource.getMessage(String.valueOf(ex.getCode()), null, locale));
        return null;
    }

    @ExceptionHandler({AuthorizationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ExceptionMessage processAuthorizationException(Locale locale, AuthorizationException ex) {
//        return new ExceptionMessage(ex.getCode(), messageSource.getMessage(String.valueOf(ex.getCode()), null, locale));
        return null;
    }

    public static class ExceptionMessage {
        private Integer code;
        private String error;
        private List detail;

        public ExceptionMessage(Integer code, String error) {
            this.code = code;
            this.error = error;
        }

        public ExceptionMessage(Integer code, String error, List detail) {
            this.code = code;
            this.error = error;
            this.detail = detail;
        }

        public Integer getCode() {
            return code;
        }

        public Object getError() {
            return error;
        }

        public List getDetail() {
            return detail;
        }
    }
}
