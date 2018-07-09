package com.creator.healthwebapp.controller;

import com.creator.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user/numcount")
    public int countNumOfUser()
    {
        return userService.countNumOfUser();
    }
}
