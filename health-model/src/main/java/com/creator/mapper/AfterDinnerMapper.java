package com.creator.mapper;

import com.creator.AfterDinner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface AfterDinnerMapper {

    int count();

    void insert(AfterDinner afterDinner);

    AfterDinner select(Long code);

    void update(AfterDinner afterDinner);

    void delete(Long code);
}
