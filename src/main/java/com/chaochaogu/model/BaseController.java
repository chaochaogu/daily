package com.chaochaogu.model;


/**
 * @author chaochao Gu
 * @date 2019/7/26
 */
public class BaseController {

    protected <T> ApiOutputDTO<T> success() {
        ApiOutputDTO<T> apiOutputDTO = new ApiOutputDTO<>();
        apiOutputDTO.setCode("0");
        apiOutputDTO.setMessage("操作成功!");
        return apiOutputDTO;
    }

    protected <T> ApiOutputDTO<T> success(T object) {
        ApiOutputDTO<T> apiOutputDTO = new ApiOutputDTO<>();
        apiOutputDTO.setCode("0");
        apiOutputDTO.setMessage("操作成功!");
        apiOutputDTO.setData(object);
        return apiOutputDTO;
    }

    protected <T> ApiOutputDTO<T> success(String code, String message, T object) {
        ApiOutputDTO<T> apiOutputDTO = new ApiOutputDTO<>();
        apiOutputDTO.setCode(code);
        apiOutputDTO.setMessage(message);
        apiOutputDTO.setData(object);
        return apiOutputDTO;
    }

    protected <T> ApiOutputDTO<T> fail() {
        ApiOutputDTO<T> apiOutputDTO = new ApiOutputDTO<>();
        apiOutputDTO.setCode("-1");
        apiOutputDTO.setMessage("操作失败!");
        return apiOutputDTO;
    }

    protected <T> ApiOutputDTO<T> fail(T object) {
        ApiOutputDTO<T> apiOutputDTO = new ApiOutputDTO<>();
        apiOutputDTO.setCode("-1");
        apiOutputDTO.setMessage("操作失败!");
        apiOutputDTO.setData(object);
        return apiOutputDTO;
    }

    protected <T> ApiOutputDTO<T> fail(String code, String message, T object) {
        ApiOutputDTO<T> apiOutputDTO = new ApiOutputDTO<>();
        apiOutputDTO.setCode(code);
        apiOutputDTO.setMessage(message);
        apiOutputDTO.setData(object);
        return apiOutputDTO;
    }
}
