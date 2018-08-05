package com.creator.healthwebapp.controller;

import com.creator.TransactionService;
import com.creator.healthwebapp.vo.TransactionVO;
import com.creator.model.TransactionPO;
import com.creator.result.ErrorCode;
import com.creator.result.Result;
import jodd.bean.BeanCopy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private static Long CODE = 123L;

    @Resource
    private TransactionService transactionService;

    @RequestMapping("/write")
    @ResponseBody
    public Result<TransactionPO> write(TransactionVO transactionVO) {
        TransactionPO transactionPO = new TransactionPO();
        BeanCopy.from(transactionVO).to(transactionPO).copy();
        transactionService.write(transactionPO);
        TransactionPO transResult = transactionService.selectByCode(CODE);
        if(null == transResult) {
            return new Result<>(ErrorCode.ParameterError.getValue(), "获取写入信息错误");
        }
        return new Result<>(ErrorCode.Ok.getValue(), transResult.toString());
    }
}
