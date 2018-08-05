package com.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class ReflectionPO {
    private Integer id;
    private Long code;
    private String dayReflection;
    private Date createTime;
}
