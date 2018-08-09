package com.creator.healthwebapp.vo.body;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhangzeyu
 */
@Getter
@Setter
@ToString
public class DefecationVO implements Serializable {
    private String feel;
    private String feelAfter;
    private String time;
}
