package com.hut.userbackend.controller;

import com.hut.userbackend.domain.User;
import com.hut.userbackend.domain.request.userRequest.UserLoginVo;
import com.hut.userbackend.domain.request.userRequest.UserRegisterVo;
import com.hut.userbackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: UserController <br/>
 * Description: <br/>
 * date: 2024/6/18 21:10<br/>
 *
 * @author Ikun<br />
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterVo userRegisterVo){
        if(userRegisterVo == null){
            return null;
        }
        String userAccount = userRegisterVo.getUserAccount();
        String userPassword = userRegisterVo.getUserPassword();
        String checkPassword = userRegisterVo.getCheckPassword();
        if(StringUtils.isAnyBlank(userAccount, userPassword, checkPassword)){
            return null;
        }
        return userService.userRegister(userAccount, userPassword, checkPassword);
    }

    @PostMapping("/login")
    public User doLogin(@RequestBody UserLoginVo userLoginVo, HttpServletRequest request){
        if(userLoginVo == null){
            return null;
        }
        String userAccount = userLoginVo.getUserAccount();
        String userPassword = userLoginVo.getUserPassword();
        if(StringUtils.isAnyBlank(userAccount, userPassword)){
            return null;
        }
        return userService.doLogin(userAccount, userPassword, request);
    }
}
