package com.creator.healthwebapp.vo.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Setter
@Getter
@ToString
public class FoodInputVO implements Serializable {
    private Long code;
    private BreakfastVO breakfastVO;
    private DinnerVO dinnerVO;
    private LunchVO lunchVO;
}
