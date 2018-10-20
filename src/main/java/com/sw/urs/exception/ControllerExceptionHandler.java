package com.sw.urs.exception;

import com.sw.urs.model.MyResponse;
import com.sw.urs.model.ResponseCode;
import com.sw.urs.util.MyResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 控制器异常处理类
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus
    public MyResponse handlerException(Exception e) {
        return MyResponseUtil.info(ResponseCode.PARAMS_ERROR,"请检查参数~");
    }
}
