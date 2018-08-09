package com.creator;

import com.creator.model.BodyOverallPO;

public interface BodyService {

    int count();

    BodyOverallPO selectByCode(Long code);

    void write(BodyOverallPO bodyOverallPO);

    void delete(Long code);
}
