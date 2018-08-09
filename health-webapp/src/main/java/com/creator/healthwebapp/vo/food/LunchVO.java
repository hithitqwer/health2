package com.creator.healthwebapp.vo.food;

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
public class LunchVO implements Serializable {
    private String food;
    private String partner;
    private String location;
}
