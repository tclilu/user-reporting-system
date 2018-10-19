package com.sw.urs.configuration;

import com.sw.urs.interceptor.LoginRequiredInterceptor;
import com.sw.urs.interceptor.PassportInterceptor;
import com.sw.urs.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class URSWebConfiguration implements WebMvcConfigurer {
    @Autowired
    private PassportInterceptor passportInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Autowired
    private PermissionInterceptor permissionInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // ticket认证
        registry.addInterceptor(passportInterceptor);
        // 登录认证
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/admin/add").addPathPatterns("");
        // 权限认证
        registry.addInterceptor(permissionInterceptor);
    }
}
