package com.creator.healthwebapp.vo.body;

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
public class BodyOverallVO implements Serializable {
    private Long code;
    private String abdomen;
    private String overall;
    private DefecationVO defecationVO;
    private String energy;
    private String waist;
    private String exercise;
    private String others;
    private String anusFeel;
}
