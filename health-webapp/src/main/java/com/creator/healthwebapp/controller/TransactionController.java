package com.creator.healthwebapp.controller;

import com.creator.LoginService;
import com.creator.TransactionService;
import com.creator.healthwebapp.vo.TransactionVO;
import com.creator.model.TransactionPO;
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
@RequestMapping("/transaction")
public class TransactionController {

    private Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Resource
    private TransactionService transactionService;

    @Resource
    private LoginService loginService;

    @RequestMapping("/count")
    @ResponseBody
    public Result<Integer> count() {
        logger.info("/transaction/count  ");
        Integer num = transactionService.count();
        logger.info("/transaction/count  返回num= {}", num);
        return new Result<>(Result.ErrorCode.OK.getCode(), num, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/write")
    @ResponseBody
    public Result<TransactionPO> write(@RequestBody TransactionVO transactionVO) {
        logger.info("/transaction/write  transactionVO= {}", transactionVO);
        Long code = loginService.getCodeByTime();
        TransactionPO transResult = transactionService.selectByCode(code);
        TransactionPO transactionPO = new TransactionPO();
        BeanCopy.from(transactionVO).to(transactionPO).copy();

        if(Objects.isNull(transResult)) {
            logger.info("/transaction/write  新录入信息 transactionPO= {}", transactionPO);
            transactionService.write(transactionPO);
        }else {
            logger.info("/transaction/write  更新信息 transactionPO= {}", transactionPO);
            transactionService.updateByCode(transactionPO);
        }

        logger.info("/transaction/write   返回transResult= {}", transResult);
        return new Result<>(Result.ErrorCode.OK.getCode(), transResult, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/selectByCode")
    @ResponseBody
    public Result<TransactionVO> selectByCode(@RequestParam("code") Long code) {
        logger.info("/transaction/selectByCode  code= {}", code);

        if(Objects.isNull(code)) {
            logger.error("/transaction/selectByCode code 不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(),"code 不能为空");
        }

        TransactionPO transactionPO = transactionService.selectByCode(code);

        if(Objects.isNull(transactionPO)) {
            logger.info("/transaction/selectByCode  code对应的信息不存在");
            return new Result<>(Result.ErrorCode.OK.getCode(), "code对应的信息不存在");
        }

        TransactionVO transactionVO = new TransactionVO();
        BeanCopy.from(transactionPO).to(transactionVO).copy();
        logger.info("/transaction/selectByCode  返回transactionVO= {}", transactionVO);
        return new Result<>(Result.ErrorCode.OK.getCode(), transactionVO, Result.ErrorCode.OK.getMsg());
    }

    @RequestMapping("/deleteByCode")
    @ResponseBody
    public Result<TransactionVO> delete(@RequestParam("code") Long code) {
        logger.info("/transaction/deleteByCode  code= {}", code);
        if(Objects.isNull(code)) {
            logger.info("/transaction/deleteByCode  code不能为空");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), "code不能为空");
        }
        TransactionPO transactionPO = transactionService.selectByCode(code);
        if(Objects.isNull(transactionPO)) {
            logger.info("/transaction/deleteByCode  code对应信息不存在");
            return new Result<>(Result.ErrorCode.OK.getCode(),"code对应信息不存在");
        }

        try{
            transactionService.deleteByCode(code);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if(!Objects.isNull(transactionService.selectByCode(code))) {
            logger.error("/transaction/deleteByCode  code对应信息删除失败  transactionPO={}", transactionPO);
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), "code对应信息删除失败");
        }
        TransactionVO transactionVO = new TransactionVO();
        BeanCopy.from(transactionPO).to(transactionVO).copy();
        logger.info("/transaction/deleteByCode  code对应信息删除成功  transactionPO={}", transactionPO);
        return new Result<>(Result.ErrorCode.OK.getCode(), transactionVO, Result.ErrorCode.OK.getMsg());
    }
}
