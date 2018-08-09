package com.creator.model.snackOrFruit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zhangzeyu
 */
@Setter
@Getter
@ToString
public class AfterBreakfast {
    private Integer id;
    private Long code;
    private List<String> medicine;
    private List<String> fruits;
    private List<String> snacks;
}
