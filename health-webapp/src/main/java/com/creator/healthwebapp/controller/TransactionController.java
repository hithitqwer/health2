package com.creator.healthwebapp.controller;

import com.creator.LoginService;
import com.creator.TransactionService;
import com.creator.healthwebapp.vo.TransactionVO;
import com.creator.model.TransactionPO;
import com.creator.result.Result;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Resource
    private TransactionService transactionService;

    @Resource
    private LoginService loginService;

    @RequestMapping("/write")
    @ResponseBody
    public Result<TransactionPO> write(TransactionVO transactionVO) {
        logger.info("/transaction/write  transactionVO= {}", transactionVO);
        TransactionPO transactionPO = new TransactionPO();
        BeanCopy.from(transactionVO).to(transactionPO).copy();
        transactionService.write(transactionPO);
        Long code = loginService.getCodeByTime();
        TransactionPO transResult = transactionService.selectByCode(code);

        if(null == transResult) {
            logger.error("/transaction/write  获取信息不存在");
            return new Result<>(Result.ErrorCode.ParamCheckError.getCode(), "获取信息不存在");
        }

        logger.info("/transaction/write   transResult= {}", transResult);
        return new Result<>(Result.ErrorCode.OK.getCode(), transResult, Result.ErrorCode.OK.getMsg());
    }
}
