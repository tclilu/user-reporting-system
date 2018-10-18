package com.sw.urs.service;

import com.sw.urs.model.AdminRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRoleServiceTest {
    private Logger logger = LoggerFactory.getLogger(AdminRoleServiceTest.class);

    @Autowired
    AdminRoleService adminRoleService;

    /**
     * 添加admin_role Service测试
     */
    @Test
    public void addAdminRole() {
        try {
            AdminRole adminRole = new AdminRole();
            adminRole.setRoleName("测试角色");
            adminRole.setStatus(0);
            System.out.println(adminRoleService.addAdminRole(adminRole));
            logger.info("添加admin_role Service正常");
        } catch (Exception e) {
            logger.error("添加admin_role Service异常" + e.getMessage());
        }
    }

    /**
     * 查询分页admin_role Service测试
     */
    @Test
    public void selectPageAdminRole() {
        try {
            System.out.println(adminRoleService.selectPageAdminRole(1,4));
            logger.info("查询分页admin_role Service正常");
        } catch (Exception e) {
            logger.error("查询分页admin_role Service异常" + e.getMessage());
        }
    }

    /**
     * 查询所有admin_role Service测试
     */
    @Test
    public void selectAllAdminRole() {
        try {
            System.out.println(adminRoleService.selectAllAdminRole());
            logger.info("查询所有admin_role Service正常");
        } catch (Exception e) {
            logger.error("查询所有admin_role Service异常" + e.getMessage());
        }
    }

    /**
     * 根据admin_role的id查询admin_role Service测试
     */
    @Test
    public void selectAdminRoleById() {
        try {
            System.out.println(adminRoleService.selectAdminRoleById(1));
            logger.info("根据admin_role的id查询admin_role Service正常");
        } catch (Exception e) {
            logger.error("根据admin_role的id查询admin_role Service异常" + e.getMessage());
        }
    }

    /**
     * 修改admin_role Service测试
     */
    @Test
    public void updateAdminRole() {
        try {
            AdminRole adminRole = new AdminRole();
            // adminRole.setId(1);
            adminRole.setId(3);
            adminRole.setRoleName("修改测试");
            adminRole.setStatus(1);
            System.out.println(adminRoleService.updateAdminRole(adminRole));
            logger.info("Service正常");
        } catch (Exception e) {
            logger.error("Service异常" + e.getMessage());
        }
    }

    /**
     * 禁用角色
     */
    @Test
    public void forbidAdminRole() {
        try {
            // System.out.println(adminRoleService.forbidAdminRole(1));
            System.out.println(adminRoleService.forbidAdminRole(3));
            logger.info("Service正常");
        } catch (Exception e) {
            logger.error("Service异常" + e.getMessage());
        }
    }

    /**
     * 解除角色的禁用
     */
    @Test
    public void unForbiddenAdminRole() {
        try {
            // System.out.println(adminRoleService.unForbiddenAdminRole(1));
            System.out.println(adminRoleService.unForbiddenAdminRole(3));
            logger.info("Service正常");
        } catch (Exception e) {
            logger.error("Service异常" + e.getMessage());
        }
    }

    /**
     * 根据admin_role的id删除角色
     */
    @Test
    public void deleteAdminRoleById() {
        try {
            // System.out.println(adminRoleService.deleteAdminRoleById(1));
            System.out.println(adminRoleService.deleteAdminRoleById(3));
            logger.info("Service正常");
        } catch (Exception e) {
            logger.error("Service异常" + e.getMessage());
        }
    }
}