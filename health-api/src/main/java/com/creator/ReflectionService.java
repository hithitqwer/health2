package com.creator;

import com.creator.model.ReflectionPO;

/**
 * @author zhangzeyu
 */
public interface ReflectionService {
    int countNum();

    int insert(ReflectionPO reflection);

    int updateByTime(ReflectionPO reflection);

    ReflectionPO selectByCode(Long code);

    void delete(Long code);
}
