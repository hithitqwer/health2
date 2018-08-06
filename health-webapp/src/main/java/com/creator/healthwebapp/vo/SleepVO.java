package com.creator.healthwebapp.vo;

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
public class SleepVO implements Serializable {
    private String lunchBreak;
    private String morningWakeUpTime;
    private String dream;
}
