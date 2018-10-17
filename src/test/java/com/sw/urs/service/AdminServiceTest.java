package com.sw.urs.service;

import com.sw.urs.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    private Logger logger = LoggerFactory.getLogger(AdminServiceTest.class);

    @Autowired
    private AdminService adminService;

    /**
     * 根据登录名查询管理人员信息Service测试
     */
    @Test
    public void selectByAdminName() {
        try {
            Admin admin = adminService.selectByAdminName("1064906334@qq.com");
            System.out.println(admin);
            logger.info("根据登录名查询管理人员信息Service层正常");
        } catch (Exception e) {
            logger.error("根据登录名查询管理人员信息Service层异常" + e.getMessage());
        }
    }

    /**
     * 添加系统人员Service测试
     */
    @Test
    public void addAdmin() {
        try {
            Map<String,Object> map = adminService.addAdmin("1064906334@qq.com","123456",2);
            System.out.println(map);
            logger.info("添加系统人员Service层正常");
        } catch (Exception e) {
            logger.error("添加系统人员Service层异常" + e.getMessage());
        }
    }

    /**
     * 系统登录Service测试
     */
    @Test
    public void login() {
        try {
            Map<String,Object> map = adminService.login("1064906334@qq.com","123456");
            System.out.println(map);
            logger.info("登录功能Service层正常");
        } catch (Exception e) {
            logger.error("登录功能Service层异常" + e.getMessage());
        }
    }

    /**
     * 根据id查询管理员Service测试
     */
    @Test
    public void selectById() {
        try {
            Admin admin = adminService.selectById(1);
            System.out.println(admin);
            logger.info("根据id查询管理员Service层正常");
        } catch (Exception e) {
            logger.error("根据id查询管理员Service层异常" + e.getMessage());
        }
    }

    /**
     * 退出登录Service测试
     */
    @Test
    public void logout() {
        try {
            adminService.logout("f03bd8e56cd4490a9af279590dd65b69");
            logger.info("退出登录Service层正常");
        } catch (Exception e) {
            logger.error("退出登录Service层异常" + e.getMessage());
        }
    }
}