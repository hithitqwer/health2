package com.creator.healthwebapp.vo.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class FoodVO implements Serializable {

    private Long code;
    private Integer breakfastNum;
    private Integer dinnerNum;
    private Integer lunchNum;
    private BreakfastVO breakfastVO;
    private DinnerVO dinnerVO;
    private LunchVO lunchVO;

    public static class FoodVOBuilder {
        private Long code;
        private Integer breakfastNum;
        private Integer dinnerNum;
        private Integer lunchNum;
        private BreakfastVO breakfastVO;
        private DinnerVO dinnerVO;
        private LunchVO lunchVO;

        public FoodVOBuilder setCode(Long code) {
            this.code = code;
            return this;
        }

        public FoodVOBuilder setBreakfastNum(Integer breakfastNum) {
            this.breakfastNum = breakfastNum;
            return this;
        }

        public FoodVOBuilder setDinnerNum(Integer dinnerNum) {
            this.dinnerNum = dinnerNum;
            return this;
        }

        public FoodVOBuilder setLunchNum(Integer lunchNum) {
            this.lunchNum = lunchNum;
            return this;
        }

        public FoodVOBuilder setBreakfastVO(BreakfastVO breakfastVO) {
            this.breakfastVO = breakfastVO;
            return this;
        }

        public FoodVOBuilder setDinnerVO(DinnerVO dinnerVO) {
            this.dinnerVO = dinnerVO;
            return this;
        }

        public FoodVOBuilder setLunchVO(LunchVO lunchVO) {
            this.lunchVO = lunchVO;
            return this;
        }

        public FoodVO build() {
            FoodVO foodVO = new FoodVO();
            foodVO.setCode(this.code);
            foodVO.setBreakfastNum(this.breakfastNum);
            foodVO.setDinnerNum(this.dinnerNum);
            foodVO.setLunchNum(this.lunchNum);
            foodVO.setDinnerVO(this.dinnerVO);
            foodVO.setBreakfastVO(this.breakfastVO);
            foodVO.setLunchVO(this.lunchVO);
            return foodVO;
        }
    }
}
