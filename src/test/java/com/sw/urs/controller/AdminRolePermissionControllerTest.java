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
public class AdminRolePermissionControllerTest {
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
     * 给角色分配权限
     * @throws Exception
     */
    @Test
    public void addAdminRolePermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/adminRolePermission/add")
                .cookie(cookie)
                .param("roleId","3")
                .param("permissionId","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询角色拥有的权限
     * @throws Exception
     */
    @Test
    public void selectByRid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRolePermission/rid")
                .cookie(cookie)
                .param("rid","3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除角色拥有的权限
     * @throws Exception
     */
    @Test
    public void deleteAdminRolePermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminRole/del")
                .cookie(cookie)
                .param("rid","3")
                .param("permissionId","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}