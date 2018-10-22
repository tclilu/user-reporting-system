package com.sw.urs.service;

import com.github.pagehelper.PageInfo;
import com.sw.urs.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
            assertNotNull(admin);
            System.out.println(admin);
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
            int result = adminService.addAdmin("1064906334@qq.com","123456",2);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
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
            assertNotNull(map);
            System.out.println(map);
        } catch (Exception e) {
            logger.error("登录功能Service层异常" + e.getMessage());
        }
    }

    /**
     * 根据id查询管理员Service测试
     */
    @Test
    public void selectAdminById() {
        try {
            Admin admin = adminService.selectAdminById(1);
            assertNotNull(admin);
            System.out.println(admin);
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
        } catch (Exception e) {
            logger.error("退出登录Service层异常" + e.getMessage());
        }
    }

    /**
     * 分页查询Admin Service测试
     */
    @Test
    public void selectPageAdmin() {
        try {
            PageInfo<Admin> adminPageInfo = adminService.selectPageAdmin(1,2);
            assertNotNull(adminPageInfo);
            System.out.println(adminPageInfo);
        } catch (Exception e) {
            logger.error("分页查询Admin Service层异常" + e.getMessage());
        }
    }

    /**
     * 查询所有Admin Service测试
     */
    @Test
    public void selectAllAdmin() {
        try {
            List<Admin> admins = adminService.selectAllAdmin();
            assertNotNull(admins);
            assertEquals(5,admins.size());
            System.out.println(admins);
        } catch (Exception e) {
            logger.error("查询所有Admin Service层异常" + e.getMessage());
        }
    }

    /**
     * 修改admin信息 Service测试
     */
    @Test
    public void updateAdmin() {
        try {
            Admin admin = new Admin();
            admin.setId(1);
            admin.setStatus(1);
            admin.setRid(1);
            admin.setAddTime(new Date());
            admin.setAvatar(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));
            admin.setTel("123456");
            admin.setNickName("修改测试");
            admin.setPassword("sdsa2324fa83afy47fa788ty43");
            admin.setSalt("qwerty");
            admin.setAdminName("小李测试");
            int result = adminService.updateAdmin(admin);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("修改admin信息 Service层异常" + e.getMessage());
        }
    }

    /**
     * 禁用admin Service测试
     */
    @Test
    public void forbidAdmin() {
        try {
            int result = adminService.forbidAdmin(1);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("禁用admin Service层异常" + e.getMessage());
        }
    }

    /**
     * 解除禁用admin Service测试
     */
    @Test
    public void unForbiddenAdmin() {
        try {
            int result = adminService.unForbiddenAdmin(1);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("解除禁用admin Service层异常" + e.getMessage());
        }
    }

    /**
     * 根据id删除admin Service测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteAdminById() {
        try {
            int result = adminService.deleteAdminById(1);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("根据id删除admin Service层异常" + e.getMessage());
        }
    }
}