package com.creator.model.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class DinnerPO{
    private Integer id;
    private Long code;
    private List<String> list;
    private List<String> partner;
    private String location;
}