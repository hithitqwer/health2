package com.creator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class AfterLunch implements Serializable {
    private List<String> medicine;
    private List<String> fruits;
    private List<String> snacks;
}
