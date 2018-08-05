package com.creator;

import com.creator.model.ReflectionPO;

public interface ReflectionService {
    int countNum();

    int insert(ReflectionPO reflection);

    int updateByTime(ReflectionPO reflection);
}
