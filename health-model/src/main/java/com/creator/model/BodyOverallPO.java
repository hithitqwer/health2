package com.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BodyOverallPO {
    /**
     * 整体的基本感觉
     */
    private Integer id;
    private Long code;
    private String abdomen;
    private String overall;
    private String energy;
    private String waist;
    private String exercise;
    private String others;
    /**
     *排便
     */
    private String anusFeel;
    private String DefecationFeel;
    private String DefecationFeelAfter;
    private String DefecationTime;
}
