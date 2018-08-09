package com.creator.healthwebapp.controller;

import com.creator.LoginService;
import com.creator.SleepService;
import com.creator.healthwebapp.vo.SleepVO;
import com.creator.model.SleepPO;
import com.creator.result.Result;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhangzeyu
 */
@RestController
@RequestMapping("/sleep")
public class SleepController {

    private Logger logger = LoggerFactory.getLogger(SleepController.class);

    @Resource
    private SleepService sleepService;

    @Resource
    private LoginService loginService;

    @RequestMapping("/count")
    @ResponseBody
    public Result<Integer> count() {
        logger.info("/sleep/count");
        Integer num = sleepService.count();
        logger.info("/sleep/count  num= {}", num);
        return new Result<>(Result.ErrorCode.OK.getCode(), num, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/selectByCode")
    @ResponseBody
    public Result<SleepVO> selectByCode(@RequestParam("code") Long code) {
        logger.info("/sleep/selectByCode  code= {}", code);
        if(Objects.isNull(code)) {
            logger.error("/sleep/selectByCode  code为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code不能为空");
        }
        SleepPO sleepPO = sleepService.selectByCode(code);
        if(Objects.isNull(sleepPO)) {
            logger.info("/sleep/selectByCode  code对应信息不存在");
            return new Result<>(Result.ErrorCode.OK.getCode(),"code对应信息不存在");
        }
        SleepVO sleepVO = new SleepVO();
        BeanCopy.from(sleepPO).to(sleepVO).copy();
        logger.info("/sleep/selectByCode  code对应信息  {}", sleepVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), sleepVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/write")
    @ResponseBody
    public Result<SleepVO> write(@RequestBody SleepVO sleepVO) {
        logger.info("/sleep/write  sleepVO= {}", sleepVO);
        if(Objects.isNull(sleepVO)) {
            logger.error("/sleep/write  sleepVO为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"sleepVO不能为空");
        }
        if(Objects.isNull(sleepVO.getCode())) {
            Long code = loginService.getCodeByTime();
            sleepVO.setCode(code);
        }
        SleepPO sleepPO = new SleepPO();
        BeanCopy.from(sleepVO).to(sleepPO).copy();
        sleepService.insert(sleepPO);
        if(Objects.isNull(sleepService.selectByCode(sleepVO.getCode()))) {
            logger.error("/sleep/write  写入失败 sleepPO= {}", sleepPO);
            return new Result<>(Result.ErrorCode.InvokeError.getCode(), sleepVO, "写入失败");
        }
        logger.info("/sleep/write  写入成功 sleepPO= {}", sleepPO);
        return new Result<>(Result.ErrorCode.OK.getCode(), sleepVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result<SleepVO> delete(@RequestParam("code") Long code) {
        logger.info("/sleep/delete  code= {}", code);
        if(Objects.isNull(code)) {
            logger.error("/sleep/delete  code为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code不能为空");
        }
        SleepPO sleepPO = sleepService.selectByCode(code);
        if(Objects.isNull(sleepPO)) {
            logger.info("/sleep/delete  code对应信息不存在");
            return new Result<>(Result.ErrorCode.OK.getCode(),"code对应信息不存在");
        }
        sleepService.deleteByCode(code);
        if(!Objects.isNull(sleepService.selectByCode(code))) {
            logger.info("/sleep/delete  code对应信息删除失败");
            return new Result<>(Result.ErrorCode.OK.getCode(),"code对应信息删除是啊比");
        }
        logger.info("/sleep/delete  code对应信息 sleepPO={} 已删除",sleepPO);
        SleepVO sleepVO = new SleepVO();
        BeanCopy.from(sleepPO).to(sleepVO).copy();
        return new Result<>(Result.ErrorCode.OK.getCode(), sleepVO, Result.ErrorCode.OK.getMsg());
    }
}
