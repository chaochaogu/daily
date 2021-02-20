package com.chaochaogu.model;

import java.io.Serializable;

/**
 * @author chaochao Gu
 * @date 2019/7/26
 */
public class ApiOutputDTO<T> implements Serializable {

    private String code;

    private String message;

    private T data;

    public ApiOutputDTO() {
    }

    public ApiOutputDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiOutputDTO(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
