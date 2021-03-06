package com.creator;

import com.creator.exception.HealthException;
import com.creator.mapper.TransactionMapper;
import com.creator.model.TransactionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author zhangzeyu
 */
@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public int count() {
        return transactionMapper.count();
    }

    @Override
    public TransactionPO write(TransactionPO transactionPO) {

        if(null == transactionPO) {
            return null;
        }
        transactionMapper.insert(transactionPO);
        return selectByCode(transactionPO.getCode());
    }

    @Override
    public TransactionPO selectByCode(Long code) {
        if(null == code) {
            return null;
        }
        return transactionMapper.selectByCode(code);
    }

    @Override
    public int updateByCode(TransactionPO transactionPO) {
        if(Objects.isNull(transactionPO)) {
            throw new HealthException("transactionPO不能为空");
        }
        return transactionMapper.updateByCode(transactionPO);
    }

    @Override
    public void deleteByCode(Long code) {
        if(Objects.isNull(code)) {
            return;
        }
        transactionMapper.deleteByCode(code);
    }
}
