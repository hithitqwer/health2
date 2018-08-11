package com.creator;

import com.creator.mapper.AfterBreakfastMapper;
import com.creator.mapper.AfterDinnerMapper;
import com.creator.mapper.AfterLunchMapper;
import com.creator.model.snackOrFruit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhangzeyu
 */
@Service
public class AfterFoodServiceImp implements AfterFoodService {

    @Autowired
    private AfterBreakfastMapper afterBreakfastMapper;

    @Autowired
    private AfterDinnerMapper afterDinnerMapper;

    @Autowired
    private AfterLunchMapper afterLunchMapper;

    @Resource
    private LoginService loginService;

    @Override
    public AfterFoodNum count() {
        AfterFoodNum afterFoodNum = new AfterFoodNum();
        afterFoodNum.setAfterBreakfastNum(afterBreakfastMapper.count());
        afterFoodNum.setAfterDinnerNum(afterDinnerMapper.count());
        afterFoodNum.setAfterLunchNum(afterLunchMapper.count());
        return afterFoodNum;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void writeAfterFood(AfterFoodPO foodPO) {

        if(Objects.isNull(foodPO) || Objects.isNull(foodPO.getCode())) {
            return;
        }

        try{
            if(!Objects.isNull(foodPO.getAfterBreakfastPO())) {
                writeAfterBreakfast(foodPO.getAfterBreakfastPO());
            }
            if(!Objects.isNull(foodPO.getAfterDinnerPO())) {
                writeAfterDinner(foodPO.getAfterDinnerPO());
            }
            if(!Objects.isNull(foodPO.getAfterLunchPO())) {
                writeAfterLunch(foodPO.getAfterLunchPO());
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void writeAfterBreakfast(AfterBreakfastPO afterBreakfastPO) {
        if(Objects.isNull(afterBreakfastPO.getCode())) {
            afterBreakfastPO.setCode(loginService.getCodeByTime());
        }
        AfterFoodPO afterFoodPO = selectByCode(afterBreakfastPO.getCode());
        if(Objects.isNull(afterFoodPO.getAfterBreakfastPO())) {
            afterBreakfastMapper.insert(afterBreakfastPO);
        }else {
            afterBreakfastMapper.update(afterBreakfastPO);
        }
    }

    @Override
    public void writeAfterDinner(AfterDinnerPO afterDinnerPO) {
        if(Objects.isNull(afterDinnerPO.getCode())) {
            afterDinnerPO.setCode(loginService.getCodeByTime());
        }
        AfterFoodPO afterFoodPO = selectByCode(afterDinnerPO.getCode());
        if(Objects.isNull(afterFoodPO.getAfterDinnerPO())) {
            afterDinnerMapper.insert(afterDinnerPO);
        }else {
            afterDinnerMapper.update(afterDinnerPO);
        }
    }

    @Override
    public void writeAfterLunch(AfterLunchPO afterLunchPO) {
        if(Objects.isNull(afterLunchPO.getCode())) {
            afterLunchPO.setCode(loginService.getCodeByTime());
        }
        AfterFoodPO afterFoodPO = selectByCode(afterLunchPO.getCode());
        if(Objects.isNull(afterFoodPO.getAfterLunchPO())) {
            afterLunchMapper.insert(afterLunchPO);
        }else {
            afterLunchMapper.update(afterLunchPO);
        }
    }

    @Override
    public AfterFoodPO selectByCode(Long code) {
        if(Objects.isNull(code)) {
            return null;
        }
        AfterFoodPO afterFoodPO = new AfterFoodPO();
        afterFoodPO.setCode(code);

        AfterBreakfastPO afterBreakfastPO = afterBreakfastMapper.select(code);
        if(!Objects.isNull(afterBreakfastPO)) {
            afterFoodPO.setAfterBreakfastPO(afterBreakfastPO);
        }
        AfterDinnerPO afterDinnerPO = afterDinnerMapper.select(code);
        if(!Objects.isNull(afterDinnerPO)) {
            afterFoodPO.setAfterDinnerPO(afterDinnerPO);
        }
        AfterLunchPO afterLunchPO = afterLunchMapper.select(code);
        if(!Objects.isNull(afterLunchPO)) {
            afterFoodPO.setAfterLunchPO(afterLunchPO);
        }

        if(Objects.isNull(afterBreakfastPO) && Objects.isNull(afterDinnerPO) && Objects.isNull(afterLunchPO)) {
            return null;
        }

        return afterFoodPO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAfterFood(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectByCode(code))) {
            return;
        }

        try{
            deleteAfterBreakfast(code);
            deleteAfterDinner(code);
            deleteAfterLunch(code);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteAfterBreakfast(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectByCode(code).getAfterBreakfastPO())) {
            return;
        }
        afterBreakfastMapper.delete(code);
    }

    @Override
    public void deleteAfterDinner(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectByCode(code).getAfterDinnerPO())) {
            return;
        }
        afterDinnerMapper.delete(code);
    }

    @Override
    public void deleteAfterLunch(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectByCode(code).getAfterLunchPO())) {
            return;
        }
        afterLunchMapper.delete(code);
    }
}
