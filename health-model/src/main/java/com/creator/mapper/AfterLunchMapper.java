package com.creator.mapper;

import com.creator.AfterLunch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface AfterLunchMapper {

    int count();

    void insert(AfterLunch afterLunch);

    AfterLunch select(Long code);

    void update(AfterLunch afterLunch);

    void delete(Long code);
}
