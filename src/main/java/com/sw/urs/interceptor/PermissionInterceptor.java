package com.sw.urs.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sw.urs.model.Admin;
import com.sw.urs.model.HostHolder;
import com.sw.urs.model.ResponseCode;
import com.sw.urs.service.AdminPermissionService;
import com.sw.urs.service.AdminRolePermissionService;
import com.sw.urs.util.MyResponseUtil;
import com.sw.urs.util.ReturnJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;

/**
 * 权限拦截
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    HostHolder hostHolder;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin admin = hostHolder.getAdmin();
        // 非法越过LoginRequiredInterceptor拦截器
        if (admin == null) {
            ReturnJsonUtil.returnJson(response,JSONObject.toJSONString("非法入侵"));
            return false;
        }
        // 判断权限的状态（0：正常；1：禁用）
        if (adminPermissionService.selectStatusByApiAddress(request.getRequestURI()) == 1) {
            // 该权限已被禁用
            ReturnJsonUtil.returnJson(response,JSONObject.toJSONString(MyResponseUtil.info(ResponseCode.PERMISSION_FORBIDDEN,"该功能被禁用，请联系管理人员或开发人员")));
            return false;
        }
        // 查询角色拥有的权限
        HashSet<String> permissions = adminRolePermissionService.selectByRid(admin.getRid());
        // 权限检测
        if (!permissions.contains(request.getRequestURI())) {
            // 无权限
            ReturnJsonUtil.returnJson(response, JSONObject.toJSONString(MyResponseUtil.info(ResponseCode.NO_PERMISSION,"您没有权限~")));
            // ReturnJsonUtil.returnJson(response,JSONObject.toJSONString(request.getRequestURI()));
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
