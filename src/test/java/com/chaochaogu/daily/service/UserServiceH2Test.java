package com.chaochaogu.daily.service;

import com.chaochaogu.DailyApplication;
import com.chaochaogu.model.User;
import com.chaochaogu.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DailyApplication.class)
@ActiveProfiles("h2")
@Transactional
@Rollback
public class UserServiceH2Test {
    private User user;

    @Autowired
    private IUserService userService;

    @Before
    public void setUp() {
        user = User.builder().password("123").status(1).telephone("13812345678").username("bruce").build();
        userService.saveUser(user);
    }

    public void tearDown() {
        userService.deleteUserById(user.getId());
    }

    @Test
    public void testQuery() {
        assert Objects.nonNull(userService.queryUserById(1));
    }
}
