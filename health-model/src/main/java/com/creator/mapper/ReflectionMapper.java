package com.creator.mapper;

import com.creator.model.ReflectionPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface ReflectionMapper {

    int countNum();

    int insert(ReflectionPO reflection);

    int updateByTime(ReflectionPO reflection);

    ReflectionPO selectByCode(Long code);

    int delete(Long code);
}
