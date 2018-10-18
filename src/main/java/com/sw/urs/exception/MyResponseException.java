package com.sw.urs.exception;

import com.sw.urs.model.ResponseCode;

/**
 * 自定义结果异常响应类
 */
public class MyResponseException extends RuntimeException {
    private ResponseCode responseCode;

    /**
     * 异常响应
     * @param responseCode
     */
    public MyResponseException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
