package com.creator.healthwebapp.controller;

import com.creator.result.LoginResult;
import com.creator.user.User;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/health")
public class HealthLogin {
    @RequestMapping("/login")
    public LoginResult login(User user)
    {

    }
}
