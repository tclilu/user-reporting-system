package com.sw.urs.service;

import com.sw.urs.model.AdminRolePermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRolePermissionServiceTest {
    private Logger logger = LoggerFactory.getLogger(AdminRolePermissionServiceTest.class);

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    /**
     * 添加角色的权限 Service测试
     */
    @Test
    public void addAdminRolePermission() {
        try {
            AdminRolePermission adminRolePermission = new AdminRolePermission();
            adminRolePermission.setRoleId(2);
            adminRolePermission.setPermissionId(2);
            System.out.println(adminRolePermissionService.addAdminRolePermission(adminRolePermission));
            logger.info("添加角色的权限 Service正常");
        } catch (Exception e) {
            logger.error("添加角色的权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 查询rid对应角色拥有的权限 Service测试
     */
    @Test
    public void selectByRid() {
        try {
            System.out.println(adminRolePermissionService.selectByRid(2));
            logger.info("查询rid对应角色拥有的权限 Service正常");
        } catch (Exception e) {
            logger.error("查询rid对应角色拥有的权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 删除对应角色的权限 Service测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteAdminRolePermission() {
        try {
            System.out.println(adminRolePermissionService.deleteAdminRolePermission(2,2));
            logger.info("删除对应角色的权限 Service正常");
        } catch (Exception e) {
            logger.error("删除对应角色的权限 Service异常" + e.getMessage());
        }
    }
}