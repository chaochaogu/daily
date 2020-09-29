package com.chaochaogu.daily.loadingcache;

/**
 * @author chaochao Gu
 * @date 2020/9/29
 */
public class UserFactory {
    private static User user = new User(1L, "lili", "0");

    private UserFactory(){

    }

    public static User getUser(){
        return user;
    }

    public static void modifyUserGender(){
        user.setGender("1");
    }
}
