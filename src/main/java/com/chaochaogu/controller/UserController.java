package com.chaochaogu.controller;

import com.chaochaogu.model.User;
import com.chaochaogu.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/queryById/{id}")
    public User queryUserById(@PathVariable("id") Integer id) {
        log.info("web query user by id {}", id);
        return userService.queryUserById(id);
    }

    @RequestMapping("/save")
    public boolean saveUser(@RequestBody User user){
        log.info("web save user {}", user);
        return userService.saveUser(user);
    }

    @RequestMapping("deleteById/{id}")
    public boolean deleteUserById(@PathVariable("id") Integer id){
        log.info("web delete user by id {}", id);
        return userService.deleteUserById(id);
    }
}
