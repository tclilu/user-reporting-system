package com.sw.urs.controller;

import com.sw.urs.model.MyResponse;
import com.sw.urs.model.ResponseCode;
import com.sw.urs.service.AdminService;
import com.sw.urs.util.MyResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/admin",produces = "application/json;charset=UTF-8")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AdminService adminService;

    /**
     * admin登录
     * @param adminName 登录用户名
     * @param password 登录密码
     * @param response
     * @return
     */
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public MyResponse doLogin(@RequestParam("adminName") String adminName,
                              @RequestParam("password") String password,
                              HttpServletResponse response) {
        try {
            Map<String,Object> map = adminService.login(adminName,password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket",map.get("ticket").toString());
                cookie.setPath("/");
                response.addCookie(cookie);
                return MyResponseUtil.success(adminService.selectAdminById(Integer.parseInt(map.get("adminId").toString())).toString());
            } else {
                return MyResponseUtil.error("error");
            }
        } catch (Exception e) {
            logger.error("登录异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 退出登录
     * @param ticket
     * @return
     */
    @RequestMapping(value = "/logout",method = {RequestMethod.GET,RequestMethod.POST})
    public MyResponse logout(@CookieValue("ticket") String ticket) {
        try {
            return adminService.logout(ticket) == 1 ? MyResponseUtil.success("退出成功") : MyResponseUtil.error("退出失败");
        } catch (Exception e) {
            logger.error("退出异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }
}
