package com.creator.mapper;

import com.creator.model.snackOrFruit.AfterDinnerPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface AfterDinnerMapper {

    int count();

    void insert(AfterDinnerPO afterDinner);

    AfterDinnerPO select(Long code);

    void update(AfterDinnerPO afterDinner);

    void delete(Long code);
}
