package com.creator.healthwebapp.controller;

import com.creator.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangzeyu
 */
@RestController
@RequestMapping("/afterfood")
public class AfterFoodController {

    private Logger logger = LoggerFactory.getLogger(AfterFoodController.class);

    @Resource
    private LoginService loginService;


}
