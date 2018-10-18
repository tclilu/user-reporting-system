package com.sw.urs.model;

public enum ResponseCode {
    SUCCESS(1,"请求成功"),
    NET_ERROR(-1,"网络异常，请稍后重试~"),
    ADMIN_NAME_ERROR(10001,"用户名不存在"),
    ADMIN_EXIST_ERROR(10002,"用户名已存在"),
    PASSWORD_ERROR(10003,"密码错误"),
    FORBIDDEN(10004,"账号已被禁用"),
    THIS_IS_ADMIN(10005,"不能对管理员进行操作"),
    PARAMS_ERROR(10101,"参数错误"),
    SQL_ERROR(10102,"数据库异常，请稍后重试~")
    ;
    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
