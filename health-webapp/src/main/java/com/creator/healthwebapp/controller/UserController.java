package com.creator.healthwebapp.controller;

import com.creator.UserService;
import com.creator.model.user.User;
import com.creator.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangzeyu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserService userService;

    @RequestMapping("/numCount")
    public Integer countNumOfUser() {
        Integer num = userService.countNumOfUser();
        logger.info("/user/numCount  统计用户user数量为 num={}", num);
        return num;
    }

    @RequestMapping("/selectById")
    @ResponseBody
    public Result<User> selectById(@RequestParam("userId") int userId) {
        logger.info("/user/selectById  userId={}", userId);
        User user = userService.selectById(userId);

        if(null == user) {
            logger.error("/user/selectByName  查询不到用户信息");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), "查询信息错误");
        }

        logger.info("查询 ID={} 的用户信息为：{}", userId, user);
        return new Result<>(Result.ErrorCode.OK.getCode(),user, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/selectByName")
    @ResponseBody
    public Result<User> selectByName(@RequestParam("userName") String userName) {
        logger.info("/user/selectByName userName={}", userName);
        User user = userService.selectByName(userName);

        if(null == user) {
            logger.error("/user/selectByName  查询不到用户信息");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"查询不到用户信息");
        }

        logger.info("查询 userName={} 的用户信息为：{}", userName, user);
        return new Result<>(Result.ErrorCode.OK.getCode(), user, Result.ErrorCode.OK.getMsg());
    }
}
