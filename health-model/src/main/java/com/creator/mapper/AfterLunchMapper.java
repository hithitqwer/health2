package com.creator.mapper;

import com.creator.model.snackOrFruit.AfterLunchPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface AfterLunchMapper {

    int count();

    void insert(AfterLunchPO afterLunch);

    AfterLunchPO select(Long code);

    void update(AfterLunchPO afterLunch);

    void delete(Long code);
}
