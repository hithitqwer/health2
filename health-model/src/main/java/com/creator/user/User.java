package com.creator.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private String userName;
    private String userKey;
    private Integer userId;
    private String userMsg;
}
