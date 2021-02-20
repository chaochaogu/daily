package com.chaochaogu.daily.service;

import com.chaochaogu.DailyApplication;
import com.chaochaogu.dao.db1.UserMapper;
import com.chaochaogu.model.User;
import com.chaochaogu.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author chaochao Gu
 * @date 2020/8/26
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("mockito")
@SpringBootTest(classes = DailyApplication.class)
public class UserServiceMockitoTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserMapper userMapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockito() {
        User user = User.builder().id(1).username("bruce").password("123456").build();
        // 单元测试一般分为四个步骤：setup、exercise、verify、teardown
        // setup 创建mock对象，设置selectByPrimaryKey的行为
        when(userMapper.selectByPrimaryKey(1)).thenReturn(user);
        // exercise 调用测试函数
        User result1 = userService.queryUserById(1);
        User result2 = userService.queryUserById(2);
        // verify 确认selectByPrimaryKey函数被正确调用，返回值符合预期
        verify(userMapper, times(1)).selectByPrimaryKey(1);
        assertThat(result1.getUsername(), is(user.getUsername()));
        assertNull(result2);
        // teardown 清理和释放资源
    }
}
