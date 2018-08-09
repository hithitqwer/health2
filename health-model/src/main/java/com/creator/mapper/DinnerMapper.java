package com.creator.mapper;

import com.creator.model.food.DinnerPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface DinnerMapper {

    int count();

    DinnerPO selectByCode(Long code);

    void update(DinnerPO dinnerPO);

    void insert(DinnerPO dinnerPO);

    void delete(Long code);
}
