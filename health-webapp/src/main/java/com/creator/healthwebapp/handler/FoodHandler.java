package com.creator.healthwebapp.handler;

import com.creator.healthwebapp.vo.food.FoodInputVO;
import com.creator.healthwebapp.vo.food.FoodVO;

/**
 * @author zhangzeyu
 */
public interface FoodHandler {

    FoodVO selectByCode(Long code);

    void insertProcess(FoodInputVO foodInputVO);

    void  deleteProcess(Long code);
}
