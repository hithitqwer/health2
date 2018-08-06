package com.creator;

import com.creator.model.TransactionPO;

public interface TransactionService {

    int count();

    TransactionPO write(TransactionPO transactionPO);

    TransactionPO selectByCode(Long code);

    int updateByCode(TransactionPO transactionPO);
}
