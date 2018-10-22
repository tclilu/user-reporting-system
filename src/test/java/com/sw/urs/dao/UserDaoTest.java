package com.sw.urs.dao;

import com.sw.urs.model.HostHolder;
import com.sw.urs.model.User;
import org.junit.Before;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    UserDao userDao;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    AdminDao adminDao;

    @Before
    public void setUp() throws Exception {
        // 注入一个admin
        // hostHolder.setAdmin(adminDao.selectById(5));
    }

    /**
     * 添加客户DAO层接口测试
     */
    @Test
    public void addUser() {
        try {
            User user = new User();
            user.setUsername("测试客户0");
            user.setSex(0);
            user.setDescription("来自湖北的客户，对碧桂园房屋比较感兴趣，联系方式123456");
            user.setEmail("12345678@qq.com");
            user.setAddTime(new Date());
            user.setStatus("有购房意向");
            user.setAdminId(4);
            user.setPayMoney(6666);
            int result = userDao.addUser(user);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("添加客户DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 管理员查询所有User(按user.id降序) DAO层接口测试
     */
    @Test
    public void adminSelectUsers() {
        try {
            List<User> users = userDao.adminSelectUsers();
            assertNotNull(users);
            System.out.println(users);
        } catch (Exception e) {
            logger.error("接口异常" + e.getMessage());
        }
    }

    /**
     * 销售人员查询User(只能看到自己添加的User) DAO层接口测试
     */
    @Test
    public void saleSelectUsers() {
        try {
            List<User> users = userDao.saleSelectUsers(2);
            assertNotNull(users);
            System.out.println(users);
        } catch (Exception e) {
            logger.error("接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id查询客户信息DAO层接口测试
     */
    @Test
    public void selectById() {
        try {
            User user = userDao.selectById(1);
            assertNotNull(user);
            System.out.println(user);
        } catch (Exception e) {
            logger.error("根据id查询客户信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 修改客户信息DAO层接口测试
     */
    @Test
    public void updateUser() {
        try {
            User user = new User();
            user.setId(1);
            user.setUsername("修改测试");
            user.setSex(1);
            user.setDescription("修改测试来自湖北的客户，对碧桂园房屋比较感兴趣，联系方式123456");
            user.setEmail("12345678@qq.com");
            user.setStatus("有购房意向测试");
            user.setPayMoney(1234);
            int result = userDao.updateUser(user);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("修改客户信息DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 根据id删除客户DAO层接口测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteById() {
        try {
            int result = userDao.deleteById(1);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("根据id删除客户DAO层接口异常" + e.getMessage());
        }
    }

    /**
     * 管理人员根据客户username模糊查询（查询全部）
     * @throws Exception
     */
    @Test
    public void adminSelectLikeUsername() throws Exception {
        List<User> users = userDao.adminSelectLikeUsername("%4%");
        assertNotNull(users);
        // List<User> users = userDao.adminSelectLikeUsername("%abcsd%");
        // assertNull(users);
        System.out.println(users);
    }

    /**
     * 销售人员根据客户username模糊查询（只能查自己添加的）
     * @throws Exception
     */
    @Test
    public void saleSelectLikeUsername() throws Exception {
        List<User> users = userDao.saleSelectLikeUsername("%4%",4);
        assertNotNull(users);
        // List<User> users = userDao.saleSelectLikeUsername("%abcsd%");
        // assertNull(users);
        System.out.println(users);
    }
}