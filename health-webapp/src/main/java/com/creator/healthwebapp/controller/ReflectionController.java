package com.creator.healthwebapp.controller;

import com.creator.Reflection;
import com.creator.ReflectionService;
import com.creator.exception.ReflectionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reflection")
public class ReflectionController {

    @Resource
    private ReflectionService reflectionService;

    @RequestMapping("/insert")
    public int insert(Reflection reflection) {
        int opt = reflectionService.insert(reflection);
        if(opt == 0) {
            throw new ReflectionException("未成功插入reflection数据！");
        }
        return opt;
    }

    @RequestMapping("/updateByTime")
    public int updateByTime(Reflection reflection) {
        return reflectionService.updateByTime(reflection);
    }
}
