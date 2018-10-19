package com.sw.urs.model;

/**
 * 自定义响应类
 */
public class MyResponse<T> {
    private int code;
    private String msg;
    private T data;

    public MyResponse() {
    }

    public MyResponse(ResponseCode responseCode,T data) {
        this(responseCode);
        this.data = data;
    }

    public MyResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
