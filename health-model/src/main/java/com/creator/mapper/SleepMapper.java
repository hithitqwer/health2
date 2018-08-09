package com.creator.mapper;

import com.creator.model.SleepPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface SleepMapper {

    int count();

    void insert(SleepPO sleepPO);

    void update(SleepPO sleepPO);

    SleepPO selectByCode(Long code);

    void deleteByCode(Long code);
}
