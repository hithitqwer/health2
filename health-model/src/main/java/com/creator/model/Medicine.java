package com.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class Medicine implements Serializable {
    private Integer id;
    private Long code;
    private List<String> medicine;
    private List<String> medicineMorning;
    private List<String> medicineNoon;
    private List<String> medicineNight;
    private List<String> medicineExternal;
}
