package com.creator.healthwebapp.vo.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhangzeyu
 */
@Getter
@Setter
@ToString
public class FoodMidVO implements Serializable {

    private Long code;
    private Integer breakfastNum;
    private Integer dinnerNum;
    private Integer lunchNum;
    private BreakfastVO breakfastVO;
    private DinnerVO dinnerVO;
    private LunchVO lunchVO;

    public static class FoodMidVOBuilder {
        private Long code;
        private Integer breakfastNum;
        private Integer dinnerNum;
        private Integer lunchNum;
        private BreakfastVO breakfastVO;
        private DinnerVO dinnerVO;
        private LunchVO lunchVO;

        public FoodMidVOBuilder setCode(Long code) {
            this.code = code;
            return this;
        }

        public FoodMidVOBuilder setBreakfastNum(Integer breakfastNum) {
            this.breakfastNum = breakfastNum;
            return this;
        }

        public FoodMidVOBuilder setDinnerNum(Integer dinnerNum) {
            this.dinnerNum = dinnerNum;
            return this;
        }

        public FoodMidVOBuilder setLunchNum(Integer lunchNum) {
            this.lunchNum = lunchNum;
            return this;
        }

        public FoodMidVOBuilder setBreakfastVO(BreakfastVO breakfastVO) {
            this.breakfastVO = breakfastVO;
            return this;
        }

        public FoodMidVOBuilder setDinnerVO(DinnerVO dinnerVO) {
            this.dinnerVO = dinnerVO;
            return this;
        }

        public FoodMidVOBuilder setLunchVO(LunchVO lunchVO) {
            this.lunchVO = lunchVO;
            return this;
        }

        public FoodMidVO build() {
            FoodMidVO foodMidVO = new FoodMidVO();
            foodMidVO.setCode(this.code);
            foodMidVO.setBreakfastNum(this.breakfastNum);
            foodMidVO.setDinnerNum(this.dinnerNum);
            foodMidVO.setLunchNum(this.lunchNum);
            foodMidVO.setDinnerVO(this.dinnerVO);
            foodMidVO.setBreakfastVO(this.breakfastVO);
            foodMidVO.setLunchVO(this.lunchVO);
            return foodMidVO;
        }
    }
}
