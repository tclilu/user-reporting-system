package com.sw.urs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sw.urs.dao.AdminPermissionDao;
import com.sw.urs.model.AdminPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class AdminPermissionService {
    @Autowired
    AdminPermissionDao adminPermissionDao;

    /**
     * 添加权限
     * @param adminPermission
     * @return
     */
    public int addAdminPermission(AdminPermission adminPermission) {
        // 过滤可能的HTML标签
        adminPermission.setPermissionName(HtmlUtils.htmlEscape(adminPermission.getPermissionName()));
        adminPermission.setApiAddress(HtmlUtils.htmlEscape(adminPermission.getApiAddress()));
        return adminPermissionDao.addAdminPermission(adminPermission);
    }

    /**
     * 查询分页权限
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<AdminPermission> selectPageAdminPermission(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<AdminPermission> adminPermissions = adminPermissionDao.selectAdminPermissions();
        PageInfo<AdminPermission> adminPermissionPageInfo = new PageInfo<>(adminPermissions);
        return adminPermissionPageInfo;
    }

    /**
     * 查询全部权限
     * @return
     */
    public List<AdminPermission> selectAllAdminPermission() {
        return adminPermissionDao.selectAdminPermissions();
    }

    /**
     * 根据权限id查询权限信息
     * @param id
     * @return
     */
    public AdminPermission selectAdminPermissionById(int id) {
        return adminPermissionDao.selectById(id);
    }

    /**
     * 修改权限信息
     * @param adminPermission
     * @return
     */
    public int updateAdminPermission(AdminPermission adminPermission) {
        return adminPermissionDao.updateAdminPermission(adminPermission);
    }

    /**
     * 禁用权限
     * @param id
     * @return
     */
    public int forbidAdminPermission(int id) {
        return adminPermissionDao.updateStatus(id,1);
    }

    /**
     * 解除权限的禁用
     * @param id
     * @return
     */
    public int unForbiddenAdminPermission(int id) {
        return adminPermissionDao.updateStatus(id,0);
    }

    /**
     * 根据权限的id删除权限
     * @param id
     * @return
     */
    public int deleteAdminPermissionById(int id) {
        return adminPermissionDao.deleteById(id);
    }
}
