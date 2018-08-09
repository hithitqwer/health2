package com.creator.model.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangzeyu
 */
@Setter
@Getter
@ToString
public class BreakfastPO{
    private Integer id;
    private Long code;
    private String food;
    private String partner;
    private String location;
}
