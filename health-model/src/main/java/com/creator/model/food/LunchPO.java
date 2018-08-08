package com.creator.model.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LunchPO {
    private Integer id;
    private Long code;
    private String food;
    private String partner;
    private String location;
}

