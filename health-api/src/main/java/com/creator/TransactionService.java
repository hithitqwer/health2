package com.creator;

import com.creator.model.TransactionPO;

/**
 * @author zhangzeyu
 */
public interface TransactionService {

    int count();

    TransactionPO write(TransactionPO transactionPO);

    TransactionPO selectByCode(Long code);

    int updateByCode(TransactionPO transactionPO);

    void deleteByCode(Long code);
}
