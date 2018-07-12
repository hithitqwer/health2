package com.creator;

import com.creator.exception.ReflectionException;
import com.creator.mapper.ReflectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ReflectionImp implements ReflectionService {

    @Autowired
    private ReflectionMapper reflectionMapper;

    @Override
    public int countNum() {
        return reflectionMapper.countNum();
    }

    @Override
    public int insert(Reflection reflection) {
        return reflectionMapper.insert(reflection);
    }

    @Override
    public String selectByTime(Date createTime) {
        return reflectionMapper.selectByTime(createTime).toString();
    }

    @Override
    public int updateByTime(Reflection reflection) {
        int opt = reflectionMapper.updateByTime(reflection);
        if(opt == 0) {
            throw new ReflectionException("未更新reflection数据表！");
        }
        return opt;
    }
}
