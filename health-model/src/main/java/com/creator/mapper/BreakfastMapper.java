package com.creator.mapper;

import com.creator.model.food.BreakfastPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BreakfastMapper {

    int count();

    BreakfastPO selectByCode(Long code);

    void update(BreakfastPO breakfastPO);

    void insert(BreakfastPO breakfastPO);

    void delete(Long code);
}
