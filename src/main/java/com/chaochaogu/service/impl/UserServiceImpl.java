package com.chaochaogu.service.impl;

import com.chaochaogu.dao.db1.UserMapper;
import com.chaochaogu.model.User;
import com.chaochaogu.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
@Slf4j
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        log.info("query user by id {}, db res:{}", id, user);
        return user;
    }

    @Override
    public boolean saveUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }
}
