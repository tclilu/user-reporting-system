package com.sw.urs.service;

import com.github.pagehelper.PageInfo;
import com.sw.urs.dao.AdminDao;
import com.sw.urs.model.HostHolder;
import com.sw.urs.model.User;
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
public class UserServiceTest {
    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    AdminDao adminDao;

    /**
     * 添加User Service层测试
     */
    @Test
    public void addUser() {
        try {
            User user = new User();
            hostHolder.setAdmin(adminDao.selectById(2));
            user.setUsername("测试客户");
            user.setSex(0);
            user.setDescription("来自湖北的客户,对碧桂园房屋比较感兴趣，联系方式123456");
            user.setEmail("12345678@qq.com");
            user.setAddTime(new Date());
            user.setStatus("有购房意向");
            user.setAdminId(2);
            user.setPayMoney(2333);
            int result = userService.addUser(user);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("添加User Service层异常" + e.getMessage());
        }
    }

    /**
     * 分页查询User Service层测试
     */
    @Test
    public void selectPageUser() {
        try {
            hostHolder.setAdmin(adminDao.selectById(1));
            PageInfo<User> users = userService.selectPageUser(2,2);
            assertNotNull(users);
        } catch (Exception e) {
            logger.error("查询分页用户Service层异常" + e.getMessage());
        }
    }

    /**
     * 查询所有User Service层测试
     */
    @Test
    public void selectAllUser() {
        try {
            hostHolder.setAdmin(adminDao.selectById(1));
            List<User> users = userService.selectAllUser();
            assertNotNull(users);
        } catch (Exception e) {
            logger.error("查询所有User Service层异常" + e.getMessage());
        }
    }

    /**
     * 根据id查询User Service层测试
     */
    @Test
    public void selectUserById() {
        try {
            User user = userService.selectUserById(3);
            assertNotNull(user);
        } catch (Exception e) {
            logger.error("根据id查询User Service层异常" + e.getMessage());
        }
    }

    /**
     * 修改User Service层测试
     */
    @Test
    @Transactional
    @Rollback
    public void updateUser() {
        try {
            User user = new User();
            user.setId(3);
            user.setUsername("修改Service测试");
            user.setDescription("修改测试");
            user.setSex(1);
            user.setEmail("1234567@123.123");
            user.setAddTime(new Date());
            user.setStatus("状态修改测试");
            user.setAdminId(3);
            user.setPayMoney(10000);
            int result = userService.updateUser(user);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("修改User Service层异常" + e.getMessage());
        }
    }

    /**
     * 根据id删除User Service层测试
     */
    @Test
    @Transactional
    @Rollback
    public void deleteUserById() throws Exception {
        assertEquals(1,userService.deleteUserById(3));
    }

    /**
     * 根据客户username模糊查询
     * @throws Exception
     */
    @Test
    public void selectUserLikeUsername() throws Exception {
        // 注入一个admin
        hostHolder.setAdmin(adminDao.selectById(4));
        List<User> users = userService.selectUserLikeUsername("4");
        assertNotNull(users);
    }
}