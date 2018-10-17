package com.sw.urs.service;

import com.sw.urs.dao.AdminDao;
import com.sw.urs.dao.LoginTicketDao;
import com.sw.urs.model.Admin;
import com.sw.urs.model.LoginTicket;
import com.sw.urs.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    LoginTicketDao loginTicketDao;

    /**
     * 根据管理人员登录名查询管理人员信息
     * @param adminName
     * @return
     */
    public Admin selectByAdminName(String adminName) {
        return adminDao.selectByAdminName(adminName);
    }

    /**
     * 添加系统人员
     * @param adminName 系统登录用户名
     * @param password 登录密码
     * @param rid 所属角色id
     * @return
     */
    public Map<String,Object> addAdmin(String adminName,String password,int rid) {
        Map<String,Object> map = new HashMap<>();
        // 参数校验
        if (StringUtils.isEmpty(adminName)) {
            map.put("msg","管理人员登录名不能为空");
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msg","管理人员登录密码不能为空");
            return map;
        }
        if (StringUtils.isEmpty(rid)) {
            map.put("msg","管理人员角色id不能为空");
            return map;
        }
        Admin admin = adminDao.selectByAdminName(adminName);
        if (admin != null) {
            map.put("msg","该登录名已存在");
            return map;
        }
        admin = new Admin();
        admin.setAdminName(adminName);
        // 生成随机盐值
        admin.setSalt(UUID.randomUUID().toString().substring(0,5));
        // 带盐加密
        admin.setPassword(MD5Util.md5(password + admin.getSalt()));
        admin.setNickName(String.format("ideamake%d",new Random().nextInt(10000)));
        admin.setTel("暂无");
        admin.setAvatar(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));
        Date date = new Date();
        date.setTime(date.getTime());
        admin.setAddTime(date);
        admin.setRid(rid);
        admin.setStatus(0);
        int result = adminDao.addAdmin(admin);
        if (result > 0) {
            map.put("msg","添加成功");
        }
        return map;
    }

    /**
     * 系统用户登录
     * @param adminName
     * @param password
     * @return
     */
    public Map<String,Object> login(String adminName,String password) {
        Map<String,Object> map = new HashMap<>();
        // 非空校验
        if (StringUtils.isEmpty(adminName)) {
            map.put("msg","登录名不能为空");
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msg","密码不能为空");
            return map;
        }
        Admin admin = adminDao.selectByAdminName(adminName);
        if (admin == null) {
            map.put("msg","登录名不存在");
            return map;
        }
        if (!MD5Util.md5(password + admin.getSalt()).equals(admin.getPassword())) {
            map.put("msg","密码不正确");
            return map;
        }
        map.put("ticket",addLoginTicket(admin.getId()));
        map.put("adminId",admin.getId());
        return map;
    }

    /**
     * 添加登录ticket并获取ticket
     * @param adminId
     * @return
     */
    private String addLoginTicket(int adminId) {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setAdminId(adminId);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicketDao.addTicket(loginTicket);
        return loginTicket.getTicket();
    }

    /**
     * 获取人员信息
     * @param id
     * @return
     */
    public Admin selectById(int id) {
        return adminDao.selectById(id);
    }

    /**
     * 退出登录，将对应ticket状态置为1
     * @param ticket
     */
    public void logout(String ticket) {
        loginTicketDao.updateStatus(ticket,1);
    }
}
