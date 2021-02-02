package com.chaochaogu.daily.loadingcache;

import lombok.Data;

/**
 * @author chaochao Gu
 * @date 2020/9/29
 */
@Data
public class User {

    private Long id;
    private String name;
    private String gender;

    public User(Long id, String name, String gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
