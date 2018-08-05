package com.creator;

import com.creator.model.TransactionPO;

public interface TransactionService {

    TransactionPO write(TransactionPO transactionPO);

    TransactionPO selectByCode(Long code);
}
