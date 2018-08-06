package com.creator.trans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhangzeyu
 */
@Setter
@Getter
@ToString
public class Afternoon implements Serializable {
    private String transaction;
}
