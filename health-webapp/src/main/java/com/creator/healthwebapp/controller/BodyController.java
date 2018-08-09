package com.creator.healthwebapp.controller;

import com.creator.BodyService;
import com.creator.LoginService;
import com.creator.healthwebapp.vo.body.BodyOverallVO;
import com.creator.healthwebapp.vo.body.DefecationVO;
import com.creator.model.BodyOverallPO;
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
@RequestMapping("/body")
public class BodyController {

    private Logger logger = LoggerFactory.getLogger(BodyController.class);

    @Resource
    private BodyService bodyService;

    @Resource
    private LoginService loginService;

    @RequestMapping("/count")
    @ResponseBody
    public Result<Integer> count() {
        logger.info("/body/count");
        Integer num = bodyService.count();
        logger.info("/body/count  num= {}", num);
        return new Result<>(Result.ErrorCode.OK.getCode(), num, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Result<BodyOverallVO> insert(@RequestBody BodyOverallVO bodyOverallVO) {
        logger.info("/body/insert  bodyOverallVO= {}", bodyOverallVO);
        if(Objects.isNull(bodyOverallVO.getCode())) {
            Long code = loginService.getCodeByTime();
            bodyOverallVO.setCode(code);
        }
        BodyOverallPO bodyOverallPO = new BodyOverallPO();
        BeanCopy.from(bodyOverallVO).to(bodyOverallPO).copy();
        bodyOverallPO.setDefecationFeel(bodyOverallVO.getDefecationVO().getFeel());
        bodyOverallPO.setDefecationFeelAfter(bodyOverallVO.getDefecationVO().getFeelAfter());
        bodyOverallPO.setDefecationTime(bodyOverallVO.getDefecationVO().getTime());

        bodyService.write(bodyOverallPO);

        if(Objects.isNull(bodyService.selectByCode(bodyOverallVO.getCode()))) {
            logger.error("/body/insert  bodyOverallVO= {} 信息写入失败", bodyOverallVO);
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"信息写入失败");
        }
        logger.info("/body/insert  bodyOverallVO= {}  信息写入成功", bodyOverallVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), bodyOverallVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/select")
    @ResponseBody
    public Result<BodyOverallVO> select(@RequestParam("code") Long code) {
        logger.info("/body/select  code= {}", code);
        if(Objects.isNull(code)) {
            logger.error("/body/select  code不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code不能为空");
        }
        BodyOverallPO bodyOverallPO = bodyService.selectByCode(code);
        if(Objects.isNull(bodyOverallPO)) {
            logger.info("/body/select   没有code= {}对应信息", code);
            return new Result<>(Result.ErrorCode.OK.getCode(),"没有code对应信息");
        }
        BodyOverallVO bodyOverallVO = new BodyOverallVO();
        BeanCopy.from(bodyOverallPO).to(bodyOverallVO).copy();

        DefecationVO defecationVO = new DefecationVO();
        defecationVO.setFeel(bodyOverallPO.getDefecationFeel());
        defecationVO.setFeelAfter(bodyOverallPO.getDefecationFeelAfter());
        defecationVO.setTime(bodyOverallPO.getDefecationTime());
        bodyOverallVO.setDefecationVO(defecationVO);

        logger.info("/body/select  code= {} 对应信息为 bodyOverallVO= {}", bodyOverallVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), bodyOverallVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result<BodyOverallVO> delete(@RequestParam("code") Long code) {
        logger.info("/body/delete  code= {}", code);
        if(Objects.isNull(code)) {
            logger.error("/body/delete  code不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code不能为空");
        }
        BodyOverallPO bodyOverallPO = bodyService.selectByCode(code);
        if(Objects.isNull(bodyOverallPO)) {
            logger.info("/body/select   没有code= {}对应信息", code);
            return new Result<>(Result.ErrorCode.OK.getCode(),"没有code对应信息");
        }

        bodyService.delete(code);

        if(!Objects.isNull(bodyService.selectByCode(code))) {
            logger.info("/body/select   code= {}对应信息删除失败", code);
            return new Result<>(Result.ErrorCode.OK.getCode(),"对应信息删除失败");
        }

        BodyOverallVO bodyOverallVO = new BodyOverallVO();
        BeanCopy.from(bodyOverallPO).to(bodyOverallVO).copy();

        DefecationVO defecationVO = new DefecationVO();
        defecationVO.setFeel(bodyOverallPO.getDefecationFeel());
        defecationVO.setFeelAfter(bodyOverallPO.getDefecationFeelAfter());
        defecationVO.setTime(bodyOverallPO.getDefecationTime());
        bodyOverallVO.setDefecationVO(defecationVO);

        logger.info("/body/delete  code= {}对应信息删除成功  bodyOverallVO= {}", code, bodyOverallVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), bodyOverallVO, Result.ErrorCode.OK.getMsg());
    }
}
