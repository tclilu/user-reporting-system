package com.sw.urs.service;

import com.sw.urs.model.AdminPermission;
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
public class AdminPermissionServiceTest {
    private Logger logger = LoggerFactory.getLogger(AdminPermissionServiceTest.class);

    @Autowired
    AdminPermissionService adminPermissionService;

    /**
     * 添加权限 Service测试
     */
    @Test
    public void addAdminPermission() {
        try {
            AdminPermission adminPermission = new AdminPermission();
            adminPermission.setParentId(0);
            adminPermission.setPermissionName("测试权限");
            adminPermission.setApiAddress("/test/add");
            adminPermission.setIsHidden(0);
            adminPermission.setStatus(0);
            System.out.println(adminPermissionService.addAdminPermission(adminPermission));
            logger.info("添加权限 Service正常");
        } catch (Exception e) {
            logger.error("添加权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 查询分页权限 Service测试
     */
    @Test
    public void selectPageAdminPermission() {
        try {
            System.out.println(adminPermissionService.selectPageAdminPermission(1,2));
            logger.info("查询分页权限 Service正常");
        } catch (Exception e) {
            logger.error("查询分页权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 查询所有权限 Service测试
     */
    @Test
    public void selectAllAdminPermission() {
        try {
            System.out.println(adminPermissionService.selectAllAdminPermission());
            logger.info("查询所有权限 Service正常");
        } catch (Exception e) {
            logger.error("查询所有权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 根据权限id查询权限 Service测试
     */
    @Test
    public void selectAdminPermissionById() {
        try {
            System.out.println(adminPermissionService.selectAdminPermissionById(1));
            logger.info("根据权限id查询权限 Service正常");
        } catch (Exception e) {
            logger.error("根据权限id查询权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 修改权限信息 Service测试
     */
    @Test
    public void updateAdminPermission() {
        try {
            AdminPermission adminPermission = new AdminPermission();
            adminPermission.setId(2);
            adminPermission.setParentId(0);
            adminPermission.setPermissionName("修改测试");
            adminPermission.setApiAddress("/test/update");
            adminPermission.setIsHidden(1);
            adminPermission.setStatus(0);
            System.out.println(adminPermissionService.updateAdminPermission(adminPermission));
            logger.info("修改权限信息 Service正常");
        } catch (Exception e) {
            logger.error("修改权限信息 Service异常" + e.getMessage());
        }
    }

    /**
     * 禁用权限 Service测试
     */
    @Test
    public void forbidAdminPermission() {
        try {
            System.out.println(adminPermissionService.forbidAdminPermission(2));
            logger.info("禁用权限 Service正常");
        } catch (Exception e) {
            logger.error("禁用权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 解除权限禁用 Service测试
     */
    @Test
    public void unForbiddenAdminPermission() {
        try {
            System.out.println(adminPermissionService.unForbiddenAdminPermission(2));
            logger.info("解除权限禁用 Service正常");
        } catch (Exception e) {
            logger.error("解除权限禁用 Service异常" + e.getMessage());
        }
    }

    /**
     * 根据权限id删除权限 Service测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteAdminPermissionById() {
        try {
            System.out.println(adminPermissionService.deleteAdminPermissionById(2));
            logger.info("根据权限id删除权限 Service正常");
        } catch (Exception e) {
            logger.error("根据权限id删除权限 Service异常" + e.getMessage());
        }
    }

    /**
     * 根据URI地址查询权限状态 测试
     * @throws Exception
     */
    @Test
    public void selectStatusByApiAddress() throws Exception {
        System.out.println(adminPermissionService.selectStatusByApiAddress("/admin/adminPermission/page"));
    }
}