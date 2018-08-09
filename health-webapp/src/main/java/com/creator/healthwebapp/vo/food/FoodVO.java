package com.creator.healthwebapp.vo.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FoodVO {
    private Long code;
    private Integer breakfastNum;
    private Integer dinnerNum;
    private Integer lunchNum;
    private BreakfastVO breakfastVO;
    private DinnerVO dinnerVO;
    private LunchVO lunchVO;
}
