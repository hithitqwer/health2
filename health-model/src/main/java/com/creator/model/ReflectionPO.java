package com.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangzeyu
 */
@Getter
@Setter
@ToString
public class ReflectionPO {
    private Integer id;
    private Long code;
    private String dayReflection;
    private String surrounding;

    public ReflectionPO(Long code) {
        this.code = code;
    }
}
