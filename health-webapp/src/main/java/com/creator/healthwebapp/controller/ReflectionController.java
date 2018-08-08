package com.creator.healthwebapp.controller;

import com.creator.LoginService;
import com.creator.ReflectionService;
import com.creator.healthwebapp.vo.ReflectionVO;
import com.creator.model.ReflectionPO;
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
@RequestMapping("/reflection")
public class ReflectionController {

    private Logger logger = LoggerFactory.getLogger(ReflectionController.class);

    @Resource
    private ReflectionService reflectionService;

    @Resource
    private LoginService loginService;

    @RequestMapping("/count")
    @ResponseBody
    public Result<Integer> count() {
        logger.info("/reflection/count  ");
        Integer num = reflectionService.countNum();
        logger.info("/reflection/count  num= {}", num);
        return new Result<>(Result.ErrorCode.OK.getCode(), num , Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/selectByCode")
    @ResponseBody
    public Result<ReflectionVO> selectByCode(@RequestParam("code") Long code) {
        logger.info("/reflection/count  code= {}", code);
        if(Objects.isNull(code)) {
            logger.info("/reflection/count code为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"传入code为空");
        }
        ReflectionPO reflectionPO = reflectionService.selectByCode(code);
        if(Objects.isNull(reflectionPO)) {
            logger.error("/reflection/count code对应信息不存在");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code对应信息不存在");
        }
        ReflectionVO reflectionVO = new ReflectionVO();
        BeanCopy.from(reflectionPO).to(reflectionVO).copy();
        logger.info("/reflection/count  reflectionVO= {}", reflectionVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), reflectionVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/write")
    @ResponseBody
    public Result<ReflectionVO> insert(@RequestBody ReflectionVO reflection) {
        logger.info("/reflection/write  reflection= {}", reflection);
        Long code = loginService.getCodeByTime();
        ReflectionPO reflectionPO = new ReflectionPO(code);
        if(Objects.isNull(reflectionService.selectByCode(code))) {
            BeanCopy.from(reflection).to(reflectionPO).copy();
            reflectionService.insert(reflectionPO);
        }else {
            reflectionService.updateByTime(reflectionPO);
        }

        if(Objects.isNull(reflectionService.selectByCode(code))) {
            logger.error("/reflection/write   reflection= {}  信息写入失败", reflection);
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), reflection, "信息写入失败");
        }
        ReflectionVO result = new ReflectionVO();
        BeanCopy.from(reflectionService.selectByCode(code)).to(result).copy();
        logger.info("/reflection/write  reflection= {}", result);
        return new Result<>(Result.ErrorCode.OK.getCode(), result, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/deleteByCode")
    @ResponseBody
    public Result<ReflectionVO> delete(@RequestParam("code") Long code) throws Exception {
        logger.info("/reflection/deleteByCode  code= {}", code);
        if(Objects.isNull(code)) {
            logger.info("/reflection/deleteByCode  code为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), "code不能为空");
        }
        ReflectionPO reflectionPO = reflectionService.selectByCode(code);
        if(Objects.isNull(reflectionPO)) {
            logger.info("/reflection/deleteByCode  code对应信息不存在");
            return new Result<>(Result.ErrorCode.OK.getCode(),"code对应信息不存在");
        }

        try{
            reflectionService.delete(code);
        }catch(Exception e){
            e.printStackTrace();
        }

        if(!Objects.isNull(reflectionService.selectByCode(code))) {
            logger.error("/reflection/deleteByCode  code对应信息删除失败  reflectionPO={}", reflectionPO);
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code对应信息删除失败");
        }
        ReflectionVO reflectionVO = new ReflectionVO();
        BeanCopy.from(reflectionPO).to(reflectionVO).copy();
        logger.info("/reflection/deleteByCode  code对应信息 {}  已删除", reflectionVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), reflectionVO, Result.ErrorCode.OK.getMsg());
    }
}
