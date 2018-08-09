package com.creator;

import com.creator.exception.HealthException;
import com.creator.mapper.ReflectionMapper;
import com.creator.model.ReflectionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangzeyu
 */
@Service
public class ReflectionServiceImp implements ReflectionService {

    @Autowired
    private ReflectionMapper reflectionMapper;

    @Override
    public int countNum() {
        return reflectionMapper.countNum();
    }

    @Override
    public int insert(ReflectionPO reflection) {
        return reflectionMapper.insert(reflection);
    }

    @Override
    public int updateByTime(ReflectionPO reflection) {
        int opt = reflectionMapper.updateByTime(reflection);
        if(opt == 0) {
            throw new HealthException("未更新reflection数据表！");
        }
        return opt;
    }

    @Override
    public ReflectionPO selectByCode(Long code) {
        if(null == code) {
            return null;
        }
        return reflectionMapper.selectByCode(code);
    }

    @Override
    public void delete(Long code) {
        if(null == code || null == selectByCode(code)) {
            return;
        }
        reflectionMapper.delete(code);
    }
}
