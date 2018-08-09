package com.creator.mapper;

import com.creator.model.food.LunchPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface LunchMapper {

    int count();

    LunchPO selectByCode(Long code);

    void update(LunchPO lunchPO);

    void insert(LunchPO lunchPO);

    void delete(Long code);
}
