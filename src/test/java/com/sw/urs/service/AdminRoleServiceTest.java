package com.sw.urs.service;

import com.github.pagehelper.PageInfo;
import com.sw.urs.model.AdminRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
            int result = adminRoleService.addAdminRole(adminRole);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
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
            PageInfo<AdminRole> pageInfo = adminRoleService.selectPageAdminRole(1,4);
            assertNotNull(pageInfo);
            System.out.println(pageInfo);
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
            List<AdminRole> adminRoles = adminRoleService.selectAllAdminRole();
            assertNotNull(adminRoles);
            assertEquals(2,adminRoles);
            System.out.println(adminRoles);
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
            AdminRole adminRole = adminRoleService.selectAdminRoleById(1);
            assertNotNull(adminRole);
            System.out.println(adminRole);
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
            int result = adminRoleService.updateAdminRole(adminRole);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
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
            int result = adminRoleService.forbidAdminRole(3);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
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
            int result = adminRoleService.unForbiddenAdminRole(3);
            assertEquals(1,result);
            assertNotNull(result);
            System.out.println(result);
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
            int result = adminRoleService.deleteAdminRoleById(3);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("Service异常" + e.getMessage());
        }
    }
}