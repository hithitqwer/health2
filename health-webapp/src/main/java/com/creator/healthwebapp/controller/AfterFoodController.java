package com.creator.healthwebapp.controller;

import com.creator.AfterFoodService;
import com.creator.LoginService;
import com.creator.healthwebapp.handler.AFoodService;
import com.creator.healthwebapp.handler.AfterFoodHandler;
import com.creator.healthwebapp.vo.afterfood.AfterFoodVO;
import com.creator.model.snackOrFruit.AfterFoodNum;
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
@RequestMapping("/afterfood")
public class AfterFoodController {

    private Logger logger = LoggerFactory.getLogger(AfterFoodController.class);

    @Resource
    private LoginService loginService;

    @Resource
    private AfterFoodService afterFoodService;

    @Resource
    private AfterFoodHandler afterFoodHandler;

    @Resource(name = "ADinnerService")
    private AFoodService aFoodService;

    @RequestMapping("/count")
    @ResponseBody
    public Result<AfterFoodNum> count() {
        logger.info("/afterfood/count  ");
        AfterFoodNum afterFoodNum = afterFoodService.count();
        logger.info("/afterfood/count    afterFoodNum= {}", afterFoodNum);
        return new Result<>(Result.ErrorCode.OK.getCode(), afterFoodNum, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/write")
    @ResponseBody
    public Result<AfterFoodVO> write(@RequestBody AfterFoodVO afterFoodVO) {
        logger.info("/afterfood/write  afterFoodVO= {}", afterFoodVO);
        if(Objects.isNull(afterFoodVO.getCode())) {
            afterFoodVO.setCode(loginService.getCodeByTime());
        }
        afterFoodHandler.write(afterFoodVO);
        if(Objects.isNull(afterFoodService.selectByCode(afterFoodVO.getCode()))) {
            logger.error("/afterfood/write  信息写入失败 afterFoodVO= {}", afterFoodVO);
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"信息写入失败");
        }
        logger.info("/afterfood/write   信息写入成功 afterFoodVO= {}", afterFoodVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), afterFoodVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/select")
    @ResponseBody
    public Result<AfterFoodVO> select(@RequestParam("code") Long code) {
        logger.info("/afterfood/select   code= {}", code);
        AfterFoodVO afterFoodVO = afterFoodHandler.select(code);
        if(Objects.isNull(afterFoodVO)) {
            logger.info("/afterfood/select   code= {}对应信息不存在", code);
            return new Result<>(Result.ErrorCode.OK.getCode(),"查询信息不存在");
        }
        logger.info("/afterfood/select   code= {}  afterFoodVO= {}", code, afterFoodVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), afterFoodVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result<AfterFoodVO> delete(@RequestParam("code") Long code) {
        logger.info("/afterfood/delete   code= {}", code);
        AfterFoodVO afterFoodVO = afterFoodHandler.select(code);
        if(Objects.isNull(code) || Objects.isNull(afterFoodVO)) {
            logger.info("/afterfood/delete   code= {}对应信息不存在", code);
            return new Result<>(Result.ErrorCode.OK.getCode(), "code对应信息不存在");
        }
        afterFoodService.deleteAfterFood(code);
        if(!Objects.isNull(afterFoodHandler.select(code))) {
            logger.error("/afterfood/delete   code= {}对应信息删除失败", code);
            return new Result<>(Result.ErrorCode.InvokeError.getCode(), "code对应信息删除失败");
        }
        logger.info("/afterfood/delete   code= {}对应信息已删除", code);
        return new Result<>(Result.ErrorCode.OK.getCode(), afterFoodVO, Result.ErrorCode.OK.getMsg());
    }
}
