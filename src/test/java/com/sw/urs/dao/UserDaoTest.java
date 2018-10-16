package com.sw.urs.dao;

import com.sw.urs.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    /**
     * 添加客户DAO层接口测试
     */
    @Test
    public void addUser() {
        try {
            User user = new User();
            user.setUsername("测试");
            user.setSex(0);
            user.setDescription("来自湖北的客户，对碧桂园房屋比较感兴趣，联系方式123456");
            user.setEmail("12345678@qq.com");
            Date date = new Date();
            date.setTime(date.getTime());
            user.setAdd_time(date);
            user.setStatus("有购房意向");
            userDao.addUser(user);
        } catch (Exception e) {
            logger.error("添加客户接口异常" + e.getMessage());
        }
    }
}