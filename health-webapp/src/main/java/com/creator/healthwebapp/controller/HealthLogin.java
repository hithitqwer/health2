package com.creator.healthwebapp.controller;

import com.creator.result.LoginResult;
import com.creator.user.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthLogin {
    @RequestMapping("/login")
    public LoginResult login(User user)
    {
        LoginResult loginResult=new LoginResult();
        loginResult.setCode(200);
        loginResult.getUserMsg(user.getUserMsg());
        loginResult.setUserName(user.getUserName());
        loginResult.setUserId(user.getUserId());
        return loginResult;
    }
    @RequestMapping("/")
    public String qw()
    {
        return "1234";
    }
    @RequestMapping("/logout")
    public LoginResult logout()
    {
        LoginResult loginResult=new LoginResult();
        loginResult.setUserName("ww");
        loginResult.setUserMsg("123321");
        loginResult.setCode(123);
        return loginResult;
    }
}
