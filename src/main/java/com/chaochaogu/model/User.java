package com.chaochaogu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
@Data
@Builder
public class User implements Serializable {

    private Integer id;

    @JsonProperty("user_name")
    private String username;

    private String password;

    private String telephone;

    private Integer status;

    private static final long serialVersionUID = 1L;

}