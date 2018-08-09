package com.creator.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhangzeyu
 */
@Setter
@Getter
@ToString
public class Result<T> {
    private Integer errorCode;

    private String msg;

    private T data;

    public enum ErrorCode {

        OK(200000, "Success"),
        ParamCheckError(400000, "参数类校验错误"),
        SignError(400400, "签名错误"),
        ServerAbsent(400404, "服务不存在"),
        NonAuth(400403, "无权访问"),
        InvokeError(500000, "服务调用失败"),
        Timeout(500100, "服务超时"),
        RouteError(500500, "路由错误、服务崩溃"),
        DependentError(500600, "依赖服务调用失败"),
        AuthError(500700, "权限不足");


        private Integer code;

        private String msg;

        ErrorCode(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public Result(Integer errorCode, T data, String msg) {
        this.errorCode = errorCode;
        this.data = data;
        this.msg = msg;
    }

    public Result(Integer errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public Result(ErrorCode errorCode) {
        this.errorCode = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public Result(ErrorCode errorCode, T obj) {
        this.errorCode = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = obj;
    }

    public void setErrorCodeAndMsg(Integer code, String msg) {
        this.errorCode = code;
        this.msg = msg;
    }

    public Result() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", msg='" + msg + '\'' +
                '}';
    }
}
