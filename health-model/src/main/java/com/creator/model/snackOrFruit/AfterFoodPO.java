package com.creator.model.snackOrFruit;

import com.creator.AfterDinner;
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

    private Integer afterBreakfastNum;
    private Integer afterDinnerNum;
    private Integer afterLunchNum;

    private AfterBreakfastPO afterBreakfastPO;
    private AfterDinner afterDinner;
    private AfterLunchPO afterLunchPO;
}
