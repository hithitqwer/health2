package com.creator.healthwebapp.vo.afterfood;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class AfterDinnerVO implements Serializable {
    private List<String> medicine;
    private List<String> fruits;
    private List<String> snacks;
}
