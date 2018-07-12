package com.creator;

import java.sql.Date;

public interface ReflectionService {
    int countNum();

    int insert(Reflection reflection);

    String selectByTime(Date createTime);

    int updateByTime(Reflection reflection);
}
