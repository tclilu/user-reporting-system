package com.sw.urs.util;

import com.sw.urs.model.MyResponse;
import com.sw.urs.model.ResponseCode;

/**
 * 响应工具类
 */
public class MyResponseUtil {

    /**
     * 请求成功
     * @param data 响应的数据
     * @return
     */
    public static MyResponse success(Object data) {
        return new MyResponse<>(ResponseCode.SUCCESS,data);
    }

    /**
     * 自定义响应信息
     * @param responseCode
     * @param data
     * @return
     */
    public static MyResponse info(ResponseCode responseCode,Object data) {
        MyResponse<Object> response = new MyResponse<>(responseCode);
        response.setData(data);
        return response;
    }

    /**
     * 请求异常
     * @param data
     * @return
     */
    public static MyResponse error(Object data) {
        return new MyResponse<>(ResponseCode.NET_ERROR,data);
    }
}
