package com.creator;

import com.creator.model.SleepPO;

public interface SleepService{

    int count();

    void insert(SleepPO sleepPO);

    SleepPO selectByCode(Long code);

    void update(SleepPO sleepPO);

    void deleteByCode(Long code);
}
