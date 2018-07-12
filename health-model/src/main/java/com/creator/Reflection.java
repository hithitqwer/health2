package com.creator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@ToString
public class Reflection implements Serializable {
    private String dayReflection;
    private Integer id;
    private Date createTime;
}
