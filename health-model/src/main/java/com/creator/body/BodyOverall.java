package com.creator.body;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class BodyOverall implements Serializable {
    private String abdomen;
    private String overall;
    private String anus;
    private String energy;
    private String waist;
    private List<String> others;
}
