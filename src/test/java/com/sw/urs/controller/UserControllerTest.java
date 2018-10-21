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
public class UserControllerTest {
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
     * 添加客户
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/user/add")
                .cookie(cookie)
                .param("username","李先生")
                .param("sex","1")
                .param("description","测试客户添加")
                .param("email","984234055@qq.com")
                .param("status","向购房")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询分页客户信息
     * @throws Exception
     */
    @Test
    public void selectPageUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/page")
                .cookie(cookie)
                .param("currentPage","1")
                .param("pageSize","5")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询全部客户
     * @throws Exception
     */
    @Test
    public void selectAllUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/all")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 根据id查询客户信息
     * @throws Exception
     */
    @Test
    public void selectUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/id")
                .cookie(cookie)
                .param("userId","6")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 修改客户信息
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/user/update")
                .cookie(cookie)
                .param("id","6")
                .param("username","李先生")
                .param("sex","1")
                .param("description","测试客户修改")
                .param("email","984234055@qq.com")
                .param("status","向购房")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除客户
     * @throws Exception
     */
    @Test
    public void deleteUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/del")
                .cookie(cookie)
                .param("id","5")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 模糊查询
     * @throws Exception
     */
    @Test
    public void selectUserLikeUsername() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/usernameKeyword")
                .cookie(cookie)
                .param("usernameKeyword","4")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}