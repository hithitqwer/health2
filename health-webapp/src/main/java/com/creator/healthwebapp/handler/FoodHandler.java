package com.creator.healthwebapp.handler;

import com.creator.FoodService;
import com.creator.healthwebapp.vo.food.BreakfastVO;
import com.creator.healthwebapp.vo.food.DinnerVO;
import com.creator.healthwebapp.vo.food.FoodVO;
import com.creator.healthwebapp.vo.food.LunchVO;
import com.creator.model.food.BreakfastPO;
import com.creator.model.food.DinnerPO;
import com.creator.model.food.LunchPO;
import jodd.bean.BeanCopy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class FoodHandler {

    @Resource
    private FoodService foodService;

    public FoodVO selectByCode(Long code) {

        Integer breakfastNum = foodService.countBreakfast();
        Integer dinnerNum = foodService.countDinner();
        Integer lunchNum = foodService.countLunch();

        BreakfastPO breakfastPO = foodService.selectBreakfastByCode(code);
        DinnerPO dinnerPO = foodService.selectDinnerByCode(code);
        LunchPO lunchPO = foodService.selectLunchByCode(code);

        BreakfastVO breakfastVO = new BreakfastVO();
        if(!Objects.isNull(breakfastPO)) {
            BeanCopy.from(breakfastPO).to(breakfastVO).copy();
        }
        DinnerVO dinnerVO = new DinnerVO();
        if(!Objects.isNull(dinnerPO)) {
            BeanCopy.from(dinnerPO).to(dinnerVO).copy();
        }
        LunchVO lunchVO = new LunchVO();
        if(!Objects.isNull(lunchPO)) {
            BeanCopy.from(lunchPO).to(lunchVO).copy();
        }

        FoodVO foodVO = new FoodVO.FoodVOBuilder()
                .setCode(code)
                .setBreakfastVO(breakfastVO)
                .setDinnerVO(dinnerVO)
                .setLunchVO(lunchVO)
                .setBreakfastNum(breakfastNum)
                .setDinnerNum(dinnerNum)
                .setLunchNum(lunchNum)
                .build();

        return foodVO;
    }
}
