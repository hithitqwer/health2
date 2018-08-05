package com.creator.healthwebapp.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class ReflectionVO implements Serializable {
    private String dayReflection;
    private String surrounding;
}
