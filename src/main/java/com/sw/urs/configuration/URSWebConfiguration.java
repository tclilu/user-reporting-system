package com.sw.urs.configuration;

import com.sw.urs.interceptor.CORSInterceptor;
import com.sw.urs.interceptor.LoginRequiredInterceptor;
import com.sw.urs.interceptor.PassportInterceptor;
import com.sw.urs.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class URSWebConfiguration implements WebMvcConfigurer {
    @Autowired
    private CORSInterceptor corsInterceptor;

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
        // 允许跨域
        registry.addInterceptor(corsInterceptor);
        // ticket认证
        registry.addInterceptor(passportInterceptor).addPathPatterns("/**");
        // 登录认证
        registry.addInterceptor(loginRequiredInterceptor).excludePathPatterns("/admin/doLogin").excludePathPatterns("/admin/logout").addPathPatterns("/admin/**");
        // 权限认证
        registry.addInterceptor(permissionInterceptor).excludePathPatterns("/admin/doLogin").excludePathPatterns("/admin/logout").addPathPatterns("/admin/**");
    }

//    /**
//     * 允许跨域
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/admin/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET","POST")
//                .maxAge(3600);
//    }
}