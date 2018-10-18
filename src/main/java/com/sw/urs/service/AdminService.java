package com.sw.urs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sw.urs.dao.AdminDao;
import com.sw.urs.dao.LoginTicketDao;
import com.sw.urs.exception.MyResponseException;
import com.sw.urs.model.Admin;
import com.sw.urs.model.LoginTicket;
import com.sw.urs.model.ResponseCode;
import com.sw.urs.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    LoginTicketDao loginTicketDao;

    /**
     * 添加系统人员（注册功能）
     * @param adminName 系统登录用户名
     * @param password 登录密码
     * @param rid 所属角色id
     * @return 数据库表影响的行数
     */
    public int addAdmin(String adminName,String password,int rid) {
        Admin admin = adminDao.selectByAdminName(adminName);
        if (admin != null) {
            throw new MyResponseException(ResponseCode.ADMIN_EXIST_ERROR);
        }
        admin = new Admin();
        admin.setAdminName(adminName);
        // 生成随机盐值
        admin.setSalt(UUID.randomUUID().toString().substring(0,5));
        // 带盐加密
        admin.setPassword(MD5Util.md5(password + admin.getSalt()));
        // 设置昵称
        admin.setNickName(String.format("ideamake%d",new Random().nextInt(10000)));
        admin.setTel("暂无");
        // 设置默认头像
        admin.setAvatar(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));
        Date date = new Date();
        date.setTime(date.getTime());
        // 设置添加时间
        admin.setAddTime(date);
        // 设置所属角色
        admin.setRid(rid);
        admin.setStatus(0);
        return adminDao.addAdmin(admin);
    }

    /**
     * 系统用户登录
     * @param adminName
     * @param password
     * @return
     */
    public Map<String,Object> login(String adminName,String password) {
        Admin admin = adminDao.selectByAdminName(adminName);
        // 登录名不存在
        if (admin == null) {
            throw new MyResponseException(ResponseCode.ADMIN_NAME_ERROR);
        }
        // 密码错误
        if (!MD5Util.md5(password + admin.getSalt()).equals(admin.getPassword())) {
            throw new MyResponseException(ResponseCode.PASSWORD_ERROR);
        }
        // 账户被禁用
        if (admin.getStatus() == 1) {
            throw new MyResponseException(ResponseCode.FORBIDDEN);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
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
     * 退出登录，将对应ticket状态置为1
     * @param ticket
     */
    public void logout(String ticket) {
        loginTicketDao.updateStatus(ticket,1);
    }

    /**
     * 根据管理人员登录名查询管理人员信息
     * @param adminName
     * @return
     */
    public Admin selectByAdminName(String adminName) {
        return adminDao.selectByAdminName(adminName);
    }

    /**
     * 分页查询Admin
     * @param currentPage 当前页
     * @param pageSize 每页数量
     * @return
     */
    public PageInfo<Admin> selectPageAdmin(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Admin> admins = adminDao.selectAdmins();
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        return adminPageInfo;
    }

    /**
     * 查询所有Admin
     * @return
     */
    public List<Admin> selectAllAdmin() {
        return adminDao.selectAdmins();
    }

    /**
     * 根据id查询管理员信息
     * @param id
     * @return
     */
    public Admin selectAdminById(int id) {
        return adminDao.selectById(id);
    }

    /**
     * 修改admin信息
     * @param admin
     * @return
     */
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    /**
     * 禁用admin
     * @param id
     * @return
     */
    public int forbidAdmin(int id) {
        return adminDao.updateStatus(id,1);
    }

    /**
     * 解除admin的禁用
     * @param id
     * @return
     */
    public int unForbiddenAdmin(int id) {
        return adminDao.updateStatus(id,0);
    }

    /**
     * 根据admin的id删除admin
     * @param id
     * @return
     */
    public int deleteAdminById(int id) {
        return adminDao.deleteById(id);
    }
}
