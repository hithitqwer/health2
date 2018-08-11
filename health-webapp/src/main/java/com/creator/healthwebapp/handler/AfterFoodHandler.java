package com.creator.healthwebapp.handler;

import com.creator.healthwebapp.vo.afterfood.AfterFoodVO;

/**
 * @author zhangzeyu
 */
public interface AfterFoodHandler {

    void write(AfterFoodVO afterFoodVO);

    AfterFoodVO select(Long code);
}
