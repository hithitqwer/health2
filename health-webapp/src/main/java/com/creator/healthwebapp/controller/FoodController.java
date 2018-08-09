package com.creator.healthwebapp.controller;

import com.creator.FoodService;
import com.creator.LoginService;
import com.creator.healthwebapp.handler.FoodHandler;
import com.creator.healthwebapp.vo.food.FoodInputVO;
import com.creator.healthwebapp.vo.food.FoodVO;
import com.creator.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private LoginService loginService;

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

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    @ResponseBody
    public Result<FoodVO> insert(@RequestBody FoodInputVO foodInputVO) {
        logger.info("/food/insert  foodInputVO= {}", foodInputVO);
        if(Objects.isNull(foodInputVO)) {
            logger.error("/food/insert  foodInputVO不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"foodInputVO不能为空");
        }
        foodHandler.insertProcess(foodInputVO);
        if(Objects.isNull(foodInputVO.getCode())) {
            foodInputVO.setCode(loginService.getCodeByTime());
        }
        FoodVO foodVO = foodHandler.selectByCode(foodInputVO.getCode());
        logger.info("/food/insert  写入后数据库中  foodVO= {}", foodVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), foodVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result<FoodVO> delete(@RequestParam("code") Long code) {
        logger.info("/food/delete  code= {}", code);
        if(Objects.isNull(code)) {
            logger.error("/food/delete  code不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code不能为空");
        }
        FoodVO foodVO = select(code).getData();
        foodHandler.deleteProcess(code);
        if(Objects.isNull(select(code).getData())) {
            logger.error("/food/delete  code对应信息删除失败");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code对应信息删除失败");
        }
        logger.info("/food/delete  code对应信息已删除  {}", foodVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), foodVO, Result.ErrorCode.OK.getMsg());
    }
}
