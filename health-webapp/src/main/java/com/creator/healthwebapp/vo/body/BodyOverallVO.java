package com.creator.healthwebapp.vo.body;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@ToString
public class BodyOverallVO implements Serializable {
    private String abdomen;
    private String overall;
    private String anus;
    private String energy;
    private String waist;
    private String exercise;
    private List<String> others;
}
