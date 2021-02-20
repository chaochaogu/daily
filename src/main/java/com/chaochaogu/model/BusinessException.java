package com.chaochaogu.model;

/**
 * @author chaochao Gu
 * @date 2019/7/26
 */
public class BusinessException extends RuntimeException {

    private String code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(BusinessEnum businessEnum) {
        super(businessEnum.getMsg());
        this.code = businessEnum.getCode();
    }

    public String getCode() {
        return code;
    }
}
