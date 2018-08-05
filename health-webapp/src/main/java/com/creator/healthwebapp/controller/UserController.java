package com.creator.healthwebapp.controller;

import com.creator.UserService;
import com.creator.model.user.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/numCount")
    public int countNumOfUser() {
        return userService.countNumOfUser();
    }

    @RequestMapping("/selectById")
    public User selectById(int userId) {
        return userService.selectById(userId);
    }

    @RequestMapping("/selectByName")
    public User selectByName(String userName) {
        return userService.selectByName(userName);
    }
}
