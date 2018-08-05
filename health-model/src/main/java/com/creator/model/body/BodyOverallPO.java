package com.creator.model.body;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class BodyOverallPO {
    private Integer id;
    private Long code;
    private String abdomen;
    private String overall;
    private String anus;
    private String energy;
    private String waist;
    private String exercise;
    private List<String> others;
}
