package com.zzx.usercenter.service;

import com.zzx.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 用户服务测试
 *
 * @author 19086
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void testAccount() {
        User user = new User();
        user.setUsername("testZhansan");
        user.setUserAccount("123456");
        user.setAvatarUrl("https://pic1.zhimg.com/v2-d0a46be0e0a519ed624d0c3ec34e6f45_r.jpg?source=1940ef5c");
        user.setGender(0);
        user.setUserPassword("123456");
        user.setPhone("123456789");
        user.setEmail("12345@qq.com");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "test";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1234";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "te";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "te st";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "test";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "testZhansan";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "lisi";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        planetCode = "12345";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertTrue(result > 0);
    }
}