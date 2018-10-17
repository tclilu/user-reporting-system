package com.sw.urs.dao;

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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRolePermissionDaoTest {
    private Logger logger = LoggerFactory.getLogger(AdminRolePermissionDaoTest.class);

    @Autowired
    AdminRolePermissionDao adminRolePermissionDao;

    /**
     * 添加角色权限DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback(false)
    public void addAdminRolePermission() {
        try {
            AdminRolePermission adminRolePermission = new AdminRolePermission();
            adminRolePermission.setRoleId(2);
            adminRolePermission.setPermissionId(1);
            adminRolePermissionDao.addAdminRolePermission(adminRolePermission);
            logger.info("添加角色权限DAO层接口正常");
        } catch (Exception e) {
            logger.error("添加角色权限DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据角色id查询该角色拥有的权限DAO层接口测试
     */
    @Test
    public void selectByRid() {
        try {
            List<AdminRolePermission> adminRolePermissions = adminRolePermissionDao.selectByRid(1);
            System.out.println(adminRolePermissions);
            logger.info("根据角色id查询该角色拥有的权限DAO层接口正常");
        } catch (Exception e) {
            logger.error("根据角色id查询该角色拥有的权限DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 删除rid对应角色的对应权限DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteAdminRolePermission() {
        try {
            int result = adminRolePermissionDao.deleteAdminRolePermission(1,2);
            System.out.println(result);
            logger.info("删除rid对应角色的对应权限DAO层接口正常");
        } catch (Exception e) {
            logger.error("删除rid对应角色的对应权限DAO层接口异常" + e.getMessage());
        }
    }
}