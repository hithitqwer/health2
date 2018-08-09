package com.creator;

import com.creator.model.food.BreakfastPO;
import com.creator.model.food.DinnerPO;
import com.creator.model.food.LunchPO;

/**
 * @author zhangzeyu
 */
public interface FoodService {
    /**
     * 读取数据行数
     * @return
     */
    int countBreakfast();

    int countDinner();

    int countLunch();

    /**
     * 根据code读取数据
     * @param code
     * @return
     */
    BreakfastPO selectBreakfastByCode(Long code);

    DinnerPO selectDinnerByCode(Long code);

    LunchPO selectLunchByCode(Long code);

    /**
     * 插入数据
     * @param breakfastPO
     */
    void insertBreakfast(BreakfastPO breakfastPO);

    void insertDinner(DinnerPO dinnerPO);

    void insertLunch(LunchPO lunchPO);

    /**
     * 更新数据
     * @param breakfastPO
     */
    void updateBreakfast(BreakfastPO breakfastPO);

    void updateDinner(DinnerPO dinnerPO);

    void updateLunch(LunchPO lunchPO);

    /**
     * 删除数据
     * @param code
     */
    void deleteBreakfast(Long code);

    void deleteDinner(Long code);

    void deleteLunch(Long code);

    /**
     * 整体查询
     * @param code
     */
    void deleteFood(Long code);
}
