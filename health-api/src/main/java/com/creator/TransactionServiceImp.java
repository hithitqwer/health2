package com.creator;

import com.creator.mapper.TransactionMapper;
import com.creator.model.TransactionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

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
}
