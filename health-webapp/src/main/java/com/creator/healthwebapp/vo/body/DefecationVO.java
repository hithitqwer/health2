package com.creator.healthwebapp.vo.body;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class DefecationVO implements Serializable {
    private String feel;
    private String feelAfter;
    private Date time;
    private String surrounding;
}
