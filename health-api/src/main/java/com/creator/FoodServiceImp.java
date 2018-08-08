package com.creator;

import com.creator.mapper.BreakfastMapper;
import com.creator.mapper.DinnerMapper;
import com.creator.mapper.LunchMapper;
import com.creator.model.food.BreakfastPO;
import com.creator.model.food.DinnerPO;
import com.creator.model.food.LunchPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class FoodServiceImp implements FoodService {

    @Autowired
    private BreakfastMapper breakfastMapper;

    @Autowired
    private DinnerMapper dinnerMapper;

    @Autowired
    private LunchMapper lunchMapper;

    @Override
    public int countBreakfast() {
        return breakfastMapper.count();
    }

    @Override
    public int countDinner() {
        return dinnerMapper.count();
    }

    @Override
    public int countLunch() {
        return lunchMapper.count();
    }

    @Override
    public BreakfastPO selectBreakfastByCode(Long code) {
        if(Objects.isNull(code)) {
            return null;
        }
        return breakfastMapper.selectByCode(code);
    }

    @Override
    public DinnerPO selectDinnerByCode(Long code) {
        if(Objects.isNull(code)) {
            return null;
        }
        return dinnerMapper.selectByCode(code);
    }

    @Override
    public LunchPO selectLunchByCode(Long code) {
        if(Objects.isNull(code)) {
            return null;
        }
        return lunchMapper.selectByCode(code);
    }

    @Override
    public void insertBreakfast(BreakfastPO breakfastPO) {
        if(Objects.isNull(breakfastPO)) {
            return;
        }
        breakfastMapper.insert(breakfastPO);
    }

    @Override
    public void insertDinner(DinnerPO dinnerPO) {
        if(Objects.isNull(dinnerPO)) {
            return;
        }
        dinnerMapper.insert(dinnerPO);
    }

    @Override
    public void insertLunch(LunchPO lunchPO) {
        if(Objects.isNull(lunchPO)) {
            return;
        }
        lunchMapper.insert(lunchPO);
    }

    @Override
    public void updateBreakfast(BreakfastPO breakfastPO) {
        if(Objects.isNull(breakfastPO)) {
            return;
        }
        breakfastMapper.update(breakfastPO);
    }

    @Override
    public void updateDinner(DinnerPO dinnerPO) {
        if(Objects.isNull(dinnerPO)) {
            return;
        }
        dinnerMapper.update(dinnerPO);
    }

    @Override
    public void updateLunch(LunchPO lunchPO) {
        if(Objects.isNull(lunchPO)) {
            return;
        }
        lunchMapper.update(lunchPO);
    }

    @Override
    public void deleteBreakfast(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectBreakfastByCode(code))) {
            return;
        }
        breakfastMapper.delete(code);
    }

    @Override
    public void deleteDinner(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectDinnerByCode(code))) {
            return;
        }
        dinnerMapper.delete(code);
    }

    @Override
    public void deleteLunch(Long code) {
        if(Objects.isNull(code) || Objects.isNull(selectLunchByCode(code))) {
            return;
        }
        lunchMapper.delete(code);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFood(Long code) {
        if(Objects.isNull(code)) {
            return;
        }
        try{
            deleteBreakfast(code);
            deleteDinner(code);
            deleteLunch(code);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
