package com.creator.healthwebapp.handler;

import com.creator.FoodService;
import com.creator.LoginService;
import com.creator.healthwebapp.vo.food.*;
import com.creator.model.food.BreakfastPO;
import com.creator.model.food.DinnerPO;
import com.creator.model.food.LunchPO;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhangzeyu
 */
@Service
public class FoodHandler {

    private Logger logger = LoggerFactory.getLogger(FoodInputVO.class);

    @Resource
    private FoodService foodService;

    @Resource
    private LoginService loginService;

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

        FoodMidVO foodMidVO = new FoodMidVO.FoodMidVOBuilder()
                .setCode(code)
                .setBreakfastVO(breakfastVO)
                .setDinnerVO(dinnerVO)
                .setLunchVO(lunchVO)
                .setBreakfastNum(breakfastNum)
                .setDinnerNum(dinnerNum)
                .setLunchNum(lunchNum)
                .build();

        FoodVO foodVO = new FoodVO();
        BeanCopy.from(foodMidVO).to(foodVO).copy();
        return foodVO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertProcess(FoodInputVO foodInputVO) {
        logger.info("foodInputVO  insert  process    foodInputVO= {}",foodInputVO);
        if(Objects.isNull(foodInputVO.getCode())) {
            Long code = loginService.getCodeByTime();
            foodInputVO.setCode(code);
        }

        try {
            BreakfastVO breakfastVO = foodInputVO.getBreakfastVO();
            if(!Objects.isNull(breakfastVO)) {
                BreakfastPO breakfastPO = new BreakfastPO();
                breakfastPO.setCode(foodInputVO.getCode());
                breakfastPO.setFood(breakfastVO.getFood());
                breakfastPO.setPartner(breakfastVO.getPartner());
                breakfastPO.setLocation(breakfastVO.getLocation());
                foodService.insertBreakfast(breakfastPO);
            }

            DinnerVO dinnerVO = foodInputVO.getDinnerVO();
            if(!Objects.isNull(dinnerVO)) {
                DinnerPO dinnerPO = new DinnerPO();
                dinnerPO.setCode(foodInputVO.getCode());
                dinnerPO.setFood(dinnerVO.getFood());
                dinnerPO.setPartner(dinnerVO.getPartner());
                dinnerPO.setLocation(dinnerVO.getLocation());
                foodService.insertDinner(dinnerPO);
            }

            LunchVO lunchVO = foodInputVO.getLunchVO();
            if(!Objects.isNull(lunchVO)) {
                LunchPO lunchPO = new LunchPO();
                lunchPO.setCode(foodInputVO.getCode());
                lunchPO.setFood(lunchVO.getFood());
                lunchPO.setPartner(lunchVO.getPartner());
                lunchPO.setLocation(lunchVO.getLocation());
                foodService.insertLunch(lunchPO);
            }
        }catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void  deleteProcess(Long code) {
        logger.info("foodVO delete process   code= {}",code);
        try{
            if(!Objects.isNull(foodService.selectBreakfastByCode(code))) {
                foodService.deleteBreakfast(code);
            }
            if(!Objects.isNull(foodService.selectDinnerByCode(code))) {
                foodService.deleteDinner(code);
            }
            if(!Objects.isNull(foodService.selectLunchByCode(code))) {
                foodService.deleteLunch(code);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
