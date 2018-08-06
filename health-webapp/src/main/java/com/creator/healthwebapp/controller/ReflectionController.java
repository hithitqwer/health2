package com.creator.healthwebapp.controller;

import com.creator.ReflectionService;
import com.creator.exception.HealthException;
import com.creator.model.ReflectionPO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangzeyu
 */
@RestController
@RequestMapping("/reflection")
public class ReflectionController {

    @Resource
    private ReflectionService reflectionService;

    @RequestMapping("/insert")
    public int insert(ReflectionPO reflection) {
        int opt = reflectionService.insert(reflection);
        if(opt == 0) {
            throw new HealthException("未成功插入reflection数据！");
        }
        return opt;
    }

    @RequestMapping("/updateByTime")
    public int updateByTime(ReflectionPO reflection) {
        return reflectionService.updateByTime(reflection);
    }
}
