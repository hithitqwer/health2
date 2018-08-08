package com.creator.healthwebapp.controller;

import com.creator.FoodService;
import com.creator.healthwebapp.handler.FoodHandler;
import com.creator.healthwebapp.vo.food.FoodVO;
import com.creator.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhangzeyu
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    private Logger logger = LoggerFactory.getLogger(FoodController.class);

    @Resource
    private FoodService foodService;

    @Resource
    private FoodHandler foodHandler;

    @RequestMapping("/count")
    @ResponseBody
    public Result<FoodVO> count() {
        logger.info("/food/count  ");
        FoodVO foodVO = new FoodVO();
        foodVO.setBreakfastNum(foodService.countBreakfast());
        foodVO.setDinnerNum(foodService.countDinner());
        foodVO.setLunchNum(foodService.countLunch());
        logger.info("/food/count   foodVO= {}", foodVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), foodVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/selectByCode")
    @ResponseBody
    public Result<FoodVO> select(@RequestParam("code") Long code) {
        logger.info("/count/selectByCode  code= {}", code);
        if(Objects.isNull(code)) {
            logger.error("/count/selectByCode  code不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code不能为空");
        }
        FoodVO foodVO = foodHandler.selectByCode(code);
        if(Objects.isNull(foodVO)) {
            logger.error("/count/selectByCode  code对应信息为空");
            return new Result<>(Result.ErrorCode.OK.getCode(),"code对应信息为空");
        }
        logger.info("/count/selectByCode  code对应的 foodVO={}", foodVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), foodVO, Result.ErrorCode.OK.getMsg());
    }
}
