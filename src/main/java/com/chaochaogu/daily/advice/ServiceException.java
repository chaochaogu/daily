package com.chaochaogu.daily.advice;

/**
 * @author chaochao Gu
 * @date 2020/10/9
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 657378777056762471L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}