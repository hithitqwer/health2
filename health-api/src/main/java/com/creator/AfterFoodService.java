package com.creator;

import com.creator.model.snackOrFruit.AfterBreakfastPO;
import com.creator.model.snackOrFruit.AfterDinnerPO;
import com.creator.model.snackOrFruit.AfterFoodPO;
import com.creator.model.snackOrFruit.AfterLunchPO;

/**
 * @author zhangzeyu
 */
public interface AfterFoodService {

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
