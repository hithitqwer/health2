package com.creator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class AfterDinner implements Serializable {
    private List<?> medicine;
    private List<String> fruits;
    private List<String> snacks;
}
