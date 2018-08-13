package com.creator.healthwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangzeyu
 */
@Controller
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "index";
    }
}
