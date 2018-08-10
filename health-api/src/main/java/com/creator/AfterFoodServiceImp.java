package com.creator;

import com.creator.model.snackOrFruit.AfterBreakfastPO;
import com.creator.model.snackOrFruit.AfterDinnerPO;
import com.creator.model.snackOrFruit.AfterFoodPO;
import com.creator.model.snackOrFruit.AfterLunchPO;
import org.springframework.stereotype.Service;

/**
 * @author zhangzeyu
 */
@Service
public class AfterFoodServiceImp implements AfterFoodService {

    @Override
    public void writeAfterFood(AfterFoodPO foodPO) {

    }

    @Override
    public void writeAfterBreakfast(AfterBreakfastPO afterBreakfastPO) {

    }

    @Override
    public void writeAfterDinner(AfterDinnerPO afterDinnerPO) {

    }

    @Override
    public void writeAfterLunch(AfterLunchPO afterLunchPO) {

    }

    @Override
    public AfterFoodPO selectByCode(Long code) {
        return null;
    }

    @Override
    public void deleteAfterFood(Long code) {

    }

    @Override
    public void deleteAfterBreakfast(Long code) {

    }

    @Override
    public void deleteAfterDinner(Long code) {

    }

    @Override
    public void deleteAfterLunch(Long code) {

    }
}
