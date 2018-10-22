package com.sw.urs.dao;

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
public class AdminPermissionDaoTest {
    private Logger logger = LoggerFactory.getLogger(AdminPermissionDao.class);

    @Autowired
    AdminPermissionDao adminPermissionDao;

    /**
     * 添加权限DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback(false)
    public void addAdminPermission() {
        try {
            AdminPermission adminPermission = new AdminPermission();
            adminPermission.setParentId(0);
            adminPermission.setPermissionName("添加销售");
            adminPermission.setApiAddress("/sale/add");
            adminPermission.setIsHidden(0);
            adminPermission.setStatus(0);
            int result = adminPermissionDao.addAdminPermission(adminPermission);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("添加权限DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id查询权限DAO层接口测试
     */
    @Test
    public void selectById() {
        try {
            AdminPermission adminPermission = adminPermissionDao.selectById(1);
            assertNotNull(adminPermission);
            System.out.println(adminPermission);
        } catch (Exception e) {
            logger.error("根据id查询权限DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 修改权限信息DAO层接口测试
     */
    @Test
    public void updateAdminPermission() {
        try {
            AdminPermission adminPermission = new AdminPermission();
            adminPermission.setId(1);
            adminPermission.setPermissionName("权限修改测试");
            adminPermission.setParentId(0);
            adminPermission.setApiAddress("/user/test");
            adminPermission.setIsHidden(1);
            adminPermission.setStatus(0);
            int result = adminPermissionDao.updateAdminPermission(adminPermission);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("修改权限信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id删除权限DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteById() {
        try {
            int result = adminPermissionDao.deleteById(1);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("根据id删除权限DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 查询权限的状态
     * @throws Exception
     */
    @Test
    public void selectStatusByApiAddress() throws Exception {
        int result = adminPermissionDao.selectStatusByApiAddress("/admin/adminPermission/page");
        assertNotNull(result);
        assertEquals(1,result);
        System.out.println(result);
    }
}