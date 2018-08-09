package com.creator.healthwebapp.vo.food;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Setter
@Getter
@ToString
public class BreakfastVO implements Serializable {
    private String food;
    private String partner;
    private String location;
}
