package com.chaochaogu.model;

public enum BusinessEnum {

    /**
     * 请求成功
     */
    OK("0", "成功"),

    /**
     * 系统错误
     */
    ERROR("-1", "系统错误"),

    /**
     * 请求参数错误
     */
    REQUEST_PARAM_ERROR("-2", "请求参数错误");

    private final String code;

    private final String msg;

    BusinessEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

