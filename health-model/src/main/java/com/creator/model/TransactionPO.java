package com.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionPO {
    private Integer id;
    private Long code;
    private String morning;
    private String afternoon;
    private String night;
}
