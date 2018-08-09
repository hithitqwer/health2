package com.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangzeyu
 */
@Getter
@Setter
@ToString
public class SleepPO {
    private Integer id;
    private Long code;
    private String lunchBreak;
    private String morningWakeUpTime;
    private String dream;
}
