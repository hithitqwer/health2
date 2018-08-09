package com.creator.mapper;

import com.creator.model.BodyOverallPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhangzeyu
 */
@Mapper
@Repository
public interface BodyOverallMapper {

    int count();

    void insert(BodyOverallPO bodyOverallPO);

    BodyOverallPO selectByCode(Long code);

    void update(BodyOverallPO bodyOverallPO);

    void deleteByCode(Long code);
}
