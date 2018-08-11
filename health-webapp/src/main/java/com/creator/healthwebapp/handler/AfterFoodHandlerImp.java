package com.creator.healthwebapp.handler;

import com.creator.AfterFoodService;
import com.creator.healthwebapp.vo.afterfood.AfterBreakfastVO;
import com.creator.healthwebapp.vo.afterfood.AfterDinnerVO;
import com.creator.healthwebapp.vo.afterfood.AfterFoodVO;
import com.creator.healthwebapp.vo.afterfood.AfterLunchVO;
import com.creator.model.snackOrFruit.AfterBreakfastPO;
import com.creator.model.snackOrFruit.AfterDinnerPO;
import com.creator.model.snackOrFruit.AfterFoodPO;
import com.creator.model.snackOrFruit.AfterLunchPO;
import jodd.bean.BeanCopy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author zhangzeyu
 */
@Service
public class AfterFoodHandlerImp implements AfterFoodHandler {

    @Resource
    private AfterFoodService afterFoodService;

    @Override
    public void write(AfterFoodVO afterFoodVO) {
        if(Objects.isNull(afterFoodVO.getCode())) {
            return;
        }
        AfterFoodPO afterFoodPO = new AfterFoodPO();

        AfterBreakfastVO afterBreakfastVO = afterFoodVO.getAfterBreakfastVO();
        if(!Objects.isNull(afterBreakfastVO)) {
            AfterBreakfastPO afterBreakfastPO = new AfterBreakfastPO();
            BeanCopy.from(afterBreakfastVO).to(afterBreakfastPO).copy();
            afterFoodPO.setAfterBreakfastPO(afterBreakfastPO);
        }
        AfterDinnerVO afterDinnerVO = afterFoodVO.getAfterDinnerVO();
        if(!Objects.isNull(afterDinnerVO)) {
            AfterDinnerPO afterDinnerPO = new AfterDinnerPO();
            BeanCopy.from(afterDinnerVO).to(afterDinnerPO).copy();
            afterFoodPO.setAfterDinnerPO(afterDinnerPO);
        }
        AfterLunchVO afterLunchVO = afterFoodVO.getAfterLunchVO();
        if(!Objects.isNull(afterLunchVO)) {
            AfterLunchPO afterLunchPO = new AfterLunchPO();
            BeanCopy.from(afterLunchVO).to(afterLunchPO).copy();
            afterFoodPO.setAfterLunchPO(afterLunchPO);
        }

        afterFoodService.writeAfterFood(afterFoodPO);
    }

    @Override
    public AfterFoodVO select(Long code) {
        if(Objects.isNull(code)) {
            return null;
        }
        AfterFoodPO afterFoodPO = afterFoodService.selectByCode(code);
        if(Objects.isNull(afterFoodPO)) {
            return null;
        }
        AfterFoodVO afterFoodVO = new AfterFoodVO();

        if(!Objects.isNull(afterFoodPO.getAfterBreakfastPO())) {
            AfterBreakfastVO afterBreakfastVO = new AfterBreakfastVO();
            BeanCopy.from(afterFoodPO.getAfterBreakfastPO()).to(afterBreakfastVO).copy();
            afterFoodVO.setAfterBreakfastVO(afterBreakfastVO);
        }
        if(!Objects.isNull(afterFoodPO.getAfterDinnerPO())) {
            AfterDinnerVO afterDinnerVO = new AfterDinnerVO();
            BeanCopy.from(afterFoodPO.getAfterDinnerPO()).to(afterDinnerVO).copy();
            afterFoodVO.setAfterDinnerVO(afterDinnerVO);
        }
        if(!Objects.isNull(afterFoodPO.getAfterLunchPO())) {
            AfterLunchVO afterLunchVO = new AfterLunchVO();
            BeanCopy.from(afterFoodPO.getAfterLunchPO()).to(afterLunchVO).copy();
            afterFoodVO.setAfterLunchVO(afterLunchVO);
        }

        return afterFoodVO;
    }

}
