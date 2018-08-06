package com.creator.model.body;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class DefecationPO {
    private Integer id;
    private Long code;
    private String feel;
    private String feelAfter;
    private Date time;
}
