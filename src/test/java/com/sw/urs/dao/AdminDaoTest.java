package com.sw.urs.dao;

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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {
    private Logger logger = LoggerFactory.getLogger(AdminDaoTest.class);

    @Autowired
    AdminDao adminDao;

    /**
     * 添加管理员人员DAO层接口测试
     */
    @Test
    @Transactional
    public void addAdmin() {
        try {
            Admin admin = new Admin();
            admin.setAdminName("admintest");
            admin.setPassword("123456");
            admin.setSalt("abcdef");
            admin.setNickName("系统管理员");
            admin.setTel("12345678");
            admin.setAvatar("http://images.nowcoder.com/head/535t.png");
            Date date = new Date();
            date.setTime(date.getTime());
            admin.setAddTime(date);
            admin.setRid(1);
            admin.setStatus(0);
            int result = adminDao.addAdmin(admin);
            System.out.println(result);
            logger.info("添加管理人员DAO层接口正常");
        } catch (Exception e) {
            logger.error("添加管理人员DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 按id降序排列查询所有Admin DAO层接口测试
     */
    @Test
    public void selectAdmins() {
        try {
            System.out.println(adminDao.selectAdmins());
            logger.info("按id降序排列查询所有Admin DAO层接口正常");
        } catch (Exception e) {
            logger.error("按id降序排列查询所有Admin DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id查询管理人员信息DAO层接口测试
     */
    @Test
    public void selectById() {
        try {
            Admin admin = adminDao.selectById(1);
            System.out.println(admin);
            logger.info("根据id查询管理人员信息DAO层接口正常");
        } catch (Exception e) {
            logger.error("根据id查询管理人员信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据管理人员登录名查询管理人员信息接口测试
     */
    @Test
    public void selectByAdminName() {
        try {
            Admin admin = adminDao.selectByAdminName("测试");
            System.out.println(admin);
            logger.info("根据管理人员登录名查询管理人员信息DAO层接口正常");
        } catch (Exception e) {
            logger.error("根据管理人员登录名查询管理人员信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 修改管理人员DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback
    public void updateAdmin() {
        try {
            Admin admin = new Admin();
            admin.setId(1);
            admin.setAdminName("修改测试");
            admin.setPassword("1212121");
            admin.setSalt("asdfgh");
            admin.setNickName("测试看看");
            admin.setTel("1234567");
            admin.setAvatar("http://images.nowcoder.com/head/535t.png");
            admin.setRid(1);
            admin.setStatus(0);
            int result = adminDao.updateAdmin(admin);
            System.out.println(result);
            logger.info("修改管理人员信息DAO层接口正常");
        } catch (Exception e) {
            logger.error("修改管理人员信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 修改admin状态
     */
    @Test
    public void updateStatus() {
        try {
            System.out.println(adminDao.updateStatus(1,1));
            logger.info("修改admin状态DAO层接口正常");
        } catch (Exception e) {
            logger.error("修改admin状态DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id删除管理人员DAO层接口测试
     */
    @Test
    public void deleteById() {
        try {
            int result = adminDao.deleteById(1);
            System.out.println(result);
            logger.info("根据id删除管理人员DAO层接口正常");
        } catch (Exception e) {
            logger.error("根据id删除管理人员DAO层接口异常" + e.getMessage());
        }
    }
}