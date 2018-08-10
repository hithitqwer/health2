package com.creator;

import com.creator.model.snackOrFruit.*;

/**
 * @author zhangzeyu
 */
public interface AfterFoodService {

    AfterFoodNum count();

    void writeAfterFood(AfterFoodPO foodPO);

    void writeAfterBreakfast(AfterBreakfastPO afterBreakfastPO);

    void writeAfterDinner(AfterDinnerPO afterDinnerPO);

    void writeAfterLunch(AfterLunchPO afterLunchPO);

    AfterFoodPO selectByCode(Long code);

    void deleteAfterFood(Long code);

    void deleteAfterBreakfast(Long code);

    void deleteAfterDinner(Long code);

    void deleteAfterLunch(Long code);
}
