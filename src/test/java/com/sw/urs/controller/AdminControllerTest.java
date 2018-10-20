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
public class AdminControllerTest {
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
     * 添加销售或其它人员
     * @throws Exception
     */
    @Test
    public void addAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/add")
                .cookie(cookie)
                .param("adminName","abcdefggass")
                .param("password","123456")
                .param("rid","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 根据登录邮箱查询系统人员
     * @throws Exception
     */
    @Test
    public void selectByAdminName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminName")
                .cookie(cookie)
                .param("adminName","tclilu@lilu.org.cn")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询分页admin信息
     * @throws Exception
     */
    @Test
    public void selectPageAdmin() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminName")
                .cookie(cookie)
                .param("adminName","tclilu@lilu.org.cn")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 查询全部admin
     * @throws Exception
     */
    @Test
    public void selectAllAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/all")
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 根据id查询admin信息
     * @throws Exception
     */
    @Test
    public void selectAdminById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/id")
                .cookie(cookie)
                .param("adminId","23")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 修改admin信息
     * @throws Exception
     */
    @Test
    public void updateAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/update")
                .cookie(cookie)
                .param("id","23")
                .param("password","123")
                .param("nickName","修改测试")
                .param("tel","15207156746")
                .param("avatar","http://images.nowcoder.com/head/666t.png")
                .param("rid","2")
                .param("status","1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 禁用销售
     * @throws Exception
     */
    @Test
    public void forbidAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/forbid")
                .cookie(cookie)
                .param("id","24")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 解除禁用
     * @throws Exception
     */
    @Test
    public void unForbiddenAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/unForbidden")
                .cookie(cookie)
                .param("id","24")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除销售或其它人员
     * @throws Exception
     */
    @Test
    public void deleteAdminById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/del")
                .cookie(cookie)
                .param("id","2")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}