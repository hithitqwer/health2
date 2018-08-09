package com.creator.user;

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
public class User implements Serializable {
    private String userName;
    private String userKey;
    private Integer userId;
    private String userMsg;
}
