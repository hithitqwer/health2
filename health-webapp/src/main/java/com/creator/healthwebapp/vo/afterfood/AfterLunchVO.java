package com.creator.healthwebapp.vo.afterfood;

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
public class AfterLunchVO implements Serializable {
    private Long code;
    private String medicine;
    private String fruits;
    private String snacks;
}
