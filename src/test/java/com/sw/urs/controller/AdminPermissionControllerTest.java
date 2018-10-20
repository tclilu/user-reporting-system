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
public class AdminPermissionControllerTest {
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
     * 添加系统权限
     * @throws Exception
     */
    @Test
    public void addAdminPermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/adminPermission/add")
                .cookie(cookie)
                .param("parentId","0")
                .param("permissionName","测试权限")
                .param("apiAddress","/admin/test")
                .param("isHidden","0")
                .param("status","0")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询分页adminPermission信息
     * @throws Exception
     */
    @Test
    public void selectPageAdminPermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminPermission/page")
                .cookie(cookie)
                .param("currentPage","1")
                .param("pageSize","4")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询全部adminPermission
     * @throws Exception
     */
    @Test
    public void selectAllAdminPermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminPermission/all")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 根据id查询adminPermission信息
     * @throws Exception
     */
    @Test
    public void selectAdminPermissionById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminPermission/id")
                .cookie(cookie)
                .param("adminPermissionId","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 修改adminPermission信息
     * @throws Exception
     */
    @Test
    public void updateAdminPermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/adminPermission/update")
                .cookie(cookie)
                .param("id","2")
                .param("parentId","0")
                .param("permissionName","权限修改测试")
                .param("apiAddress","/admin/test")
                .param("isHidden","0")
                .param("status","0")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 禁用权限
     * @throws Exception
     */
    @Test
    public void forbidAdminPermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminPermission/forbid")
                .cookie(cookie)
                .param("id","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 解除禁用
     * @throws Exception
     */
    @Test
    public void unForbiddenAdminPermission() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminPermission/unForbidden")
                .cookie(cookie)
                .param("id","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除权限
     * @throws Exception
     */
    @Test
    public void deleteAdminPermissionById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminPermission/del")
                .cookie(cookie)
                .param("id","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}