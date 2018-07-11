package com.creator.trans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Night implements Serializable {
    private String transaction;
}