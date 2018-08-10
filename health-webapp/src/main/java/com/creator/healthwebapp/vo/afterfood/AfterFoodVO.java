package com.creator.healthwebapp.vo.afterfood;

import com.creator.model.Medicine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhangzeyu
 */
@Setter
@Getter
@ToString
public class AfterFoodVO implements Serializable {
    private Long code;
    private AfterBreakfastVO afterBreakfastVO;
    private AfterDinnerVO afterDinnerVO;
    private AfterLunchVO afterLunchVO;
    private Medicine medicine;
}
