package com.creator.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class LoginResult implements Serializable {
    private Integer code;
    private String userName;
    private String userMsg;
    private Integer userId;
}
