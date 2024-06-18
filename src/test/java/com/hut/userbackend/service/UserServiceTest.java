package com.hut.userbackend.service;

import com.hut.userbackend.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: UserServiceTest <br/>
 * Description: <br/>
 * date: 2024/6/18 19:44<br/>
 *
 * @author Ikun<br />
 * @since 1.0.0
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void testInsertUser(){
        User user = new User();
        user.setUsername("yk");
        user.setUserAccount("13");
        user.setAvatarUrl("gewew");
        user.setGender(0);
        user.setUserPassword("123123");
        user.setEmail("123");
        user.setPhone("456");
        userService.save(user);
    }

    @Test
    void userRegister() {
        String userAccount = "kkkk";
        String userPassword = "123456789";
        String checkPassword = "123456789";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        System.out.println(result);
    }
}