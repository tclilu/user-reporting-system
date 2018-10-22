package com.sw.urs.dao;

import com.sw.urs.model.AdminRole;
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
public class AdminRoleDaoTest {
    private Logger logger = LoggerFactory.getLogger(AdminRoleDaoTest.class);

    @Autowired
    AdminRoleDao adminRoleDao;

    /**
     * 添加系统角色DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback(false)
    public void addAdminRole() {
        try {
            AdminRole adminRole = new AdminRole();
            adminRole.setRoleName("管理人员");
            adminRole.setStatus(0);
            int result = adminRoleDao.addAdminRole(adminRole);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("添加系统角色DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id查询系统角色信息DAO层接口测试
     */
    @Test
    public void selectById() {
        try {
            AdminRole adminRole = adminRoleDao.selectById(1);
            assertNotNull(adminRole);
            System.out.println(adminRole);
        } catch (Exception e) {
            logger.error("查询系统角色信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 修改角色信息DAO层接口测试
     */
    @Test
    public void updateAdminRole() {
        try {
            AdminRole adminRole = new AdminRole();
            adminRole.setId(1);
            adminRole.setRoleName("修改测试");
            adminRole.setStatus(0);
            int result = adminRoleDao.updateAdminRole(adminRole);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("修改角色信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id删除角色DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteById() {
        try {
            int result = adminRoleDao.deleteById(1);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("删除角色DAO层接口异常" + e.getMessage());
        }
    }
}