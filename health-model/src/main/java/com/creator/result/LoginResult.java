package com.creator.result;

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
public class LoginResult implements Serializable {
    private Integer code;
    private String userName;
    private String userMsg;
    private Integer userId;
}
