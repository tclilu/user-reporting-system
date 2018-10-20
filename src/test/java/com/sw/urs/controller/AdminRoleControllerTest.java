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
public class AdminRoleControllerTest {
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
     * 添加系统角色
     * @throws Exception
     */
    @Test
    public void addAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/adminRole/add")
                .cookie(cookie)
                .param("roleName","测试角色")
                .param("status","0")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询分页adminRole信息
     * @throws Exception
     */
    @Test
    public void selectPageAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRole/page")
                .cookie(cookie)
                .param("currentPage","1")
                .param("pageSize","4")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询全部adminRole
     * @throws Exception
     */
    @Test
    public void selectAllAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRole/all")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 根据id查询adminRole信息
     * @throws Exception
     */
    @Test
    public void selectAdminRoleById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRole/id")
                .cookie(cookie)
                .param("adminRoleId","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 修改adminRole信息
     * @throws Exception
     */
    @Test
    public void updateAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/adminRole/update")
                .cookie(cookie)
                .param("id","3")
                .param("roleName","修改测试")
                .param("status","0")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 禁用角色
     * @throws Exception
     */
    @Test
    public void forbidAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRole/forbid")
                .cookie(cookie)
                .param("id","3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 解除禁用
     * @throws Exception
     */
    @Test
    public void unForbiddenAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRole/unForbidden")
                .cookie(cookie)
                .param("id","3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除角色
     * @throws Exception
     */
    @Test
    public void deleteAdminRoleById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRole/del")
                .cookie(cookie)
                .param("id","3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}