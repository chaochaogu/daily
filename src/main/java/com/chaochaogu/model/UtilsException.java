package com.chaochaogu.model;

/**
 * 类UtilsException.java的实现描述：工具类相关异常类（封装工具层异常，避免上层业务由于底层jar替换需要更改异常处理策略）
 *
 * @author chenbin 2018/4/2 下午4:39
 */
public class UtilsException extends RuntimeException {

    public UtilsException(String message, Throwable cause) {
        super(message, cause);
    }
}
