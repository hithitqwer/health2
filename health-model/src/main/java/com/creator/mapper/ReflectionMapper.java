package com.creator.mapper;

import com.creator.Reflection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Mapper
@Repository
public interface ReflectionMapper {

    int countNum();

    int insert(Reflection reflection);

    String selectByTime(Date createTime);

    int updateByTime(Reflection reflection);
}
