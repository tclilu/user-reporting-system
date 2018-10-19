package com.sw.urs.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sw.urs.model.HostHolder;
import com.sw.urs.model.ResponseCode;
import com.sw.urs.util.MyResponseUtil;
import com.sw.urs.util.ReturnJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {
    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截未登录的请求
        if (hostHolder.getAdmin() == null) {
            ReturnJsonUtil.returnJson(response,JSONObject.toJSONString(MyResponseUtil.info(ResponseCode.NO_LOGIN,"请先登录~")));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
