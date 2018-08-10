package com.creator.model.snackOrFruit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangzeyu
 */
@Setter
@Getter
@ToString
public class AfterFoodPO {
    private Long code;
    private AfterBreakfastPO afterBreakfastPO;
    private AfterDinnerPO afterDinnerPO;
    private AfterLunchPO afterLunchPO;
}
