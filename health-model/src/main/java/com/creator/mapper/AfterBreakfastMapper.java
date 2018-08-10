package com.creator.mapper;

import com.creator.model.snackOrFruit.AfterBreakfastPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface AfterBreakfastMapper {

    int count();

    void insert(AfterBreakfastPO afterBreakfastPO);

    AfterBreakfastPO select(Long code);

    void update(AfterBreakfastPO afterBreakfastPO);

    void delete(Long code);
}
