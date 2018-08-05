package com.creator.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Result<T> {

    private int errorCode;

    private String msg;

    private T data;

    public Result(){}

    public Result(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public Result(int errorCode, String msg, T data) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public void setErrorCodeAndMsg(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }
}
