package com.creator;

import com.creator.mapper.SleepMapper;
import com.creator.model.SleepPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SleepServiceImp implements SleepService{

    @Autowired
    private SleepMapper sleepMapper;

    @Override
    public int count() {
        return sleepMapper.count();
    }

    @Override
    public void insert(SleepPO sleepPO) {
        if(Objects.isNull(sleepPO.getCode())) {
            throw new RuntimeException();
        }
        if(Objects.isNull(selectByCode(sleepPO.getCode()))) {
            sleepMapper.insert(sleepPO);
        }else {
            sleepMapper.update(sleepPO);
        }
    }

    @Override
    public SleepPO selectByCode(Long code) {
        if(Objects.isNull(code)) {
            return null;
        }
        return sleepMapper.selectByCode(code);
    }

    @Override
    public void update(SleepPO sleepPO) {
        if(Objects.isNull(sleepPO.getCode())) {
            throw new RuntimeException();
        }
        sleepMapper.update(sleepPO);
    }

    @Override
    public void deleteByCode(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectByCode(code))) {
            return;
        }
        sleepMapper.deleteByCode(code);
    }
}
