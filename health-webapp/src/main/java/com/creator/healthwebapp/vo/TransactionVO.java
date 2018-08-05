package com.creator.healthwebapp.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class TransactionVO implements Serializable {
    private String morning;
    private String afternoon;
    private String night;
}
