package com.sw.urs.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankingControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private Cookie cookie;

    /**
     * 初始化相关配置
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        cookie = new Cookie("ticket","c9bc4b47e7d24cf4b750292f018665af");
        cookie.setPath("/");
    }

    /**
     * 按照客户总数进行本周排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisWeek() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserCountByThisWeek")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 按照客户总数进行本月排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisMonth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserCountByThisMonth")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 按照客户总数进行本年排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisYear() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserCountByThisYear")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 任意日期范围客户总数排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByDateRange() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserCountByDateRange")
                .cookie(cookie)
                .param("smallDate","2018-10-19")
                .param("bigDate","2018-10-21")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 按照客户消费总金额进行本周排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisWeek() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserPayByThisWeek")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 按照客户消费总金额进行本月排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisMonth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserPayByThisMonth")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 按照客户消费总金额进行本年排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisYear() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserPayByThisYear")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 任意日期范围客户消费总金额排名 测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByDateRange() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/rankUserPayByDateRange")
                .cookie(cookie)
                .param("smallDate","2018-10-19")
                .param("bigDate","2018-10-21")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}