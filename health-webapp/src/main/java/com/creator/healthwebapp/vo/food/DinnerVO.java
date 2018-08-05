package com.creator.healthwebapp.vo.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@ToString
public class DinnerVO implements Serializable {
    private List<String> list;
    private List<String> partner;
    private String location;
}
