package com.creator.mapper;

import com.creator.model.TransactionPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface TransactionMapper {

    int count();

    int insert(TransactionPO transactionPO);

    TransactionPO selectByCode(Long code);

    int updateByCode(TransactionPO transactionPO);
}
