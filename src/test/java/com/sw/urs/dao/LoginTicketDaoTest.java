package com.sw.urs.dao;

import com.sw.urs.model.LoginTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTicketDaoTest {
    private Logger logger = LoggerFactory.getLogger(LoginTicketDaoTest.class);

    @Autowired
    LoginTicketDao loginTicketDao;

    /**
     * 添加ticket DAO层接口测试
     */
    @Test
    public void addTicket() {
        try {
            LoginTicket loginTicket = new LoginTicket();
            loginTicket.setAdminId(1);
            loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*24);
            loginTicket.setExpired(date);
            loginTicket.setStatus(0);
            int result = loginTicketDao.addTicket(loginTicket);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("添加ticket接口异常" + e.getMessage());
        }
    }

    /**
     * 根据ticket查询ticket信息接口测试
     */
    @Test
    public void selectByTicket() {
        try {
            LoginTicket loginTicket = loginTicketDao.selectByTicket("3bdf98666b984cb2941d84d21c1a712d");
            assertNotNull(loginTicket);
            System.out.println(loginTicket);
        } catch (Exception e) {
            logger.error("根据ticket查询ticket接口异常" + e.getMessage());
        }
    }

    /**
     * 修改ticket接口测试
     */
    @Test
    public void updateStatus() {
        try {
            int result = loginTicketDao.updateStatus("f03bd8e56cd4490a9af279590dd65b69",1);
            assertNotNull(result);
            assertEquals(1,result);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("修改ticket接口异常" + e.getMessage());
        }
    }
}