package com.chaochaogu.service;

import com.chaochaogu.model.User;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
public interface IUserService {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 保存用户
     * @param user
     * @return
     */
    boolean saveUser(User user);

    /**
     * 根据Id删除用户
     * @param id
     * @return
     */
    boolean deleteUserById(Integer id);
}
