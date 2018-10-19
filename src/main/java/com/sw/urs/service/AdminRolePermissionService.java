package com.sw.urs.service;

import com.sw.urs.dao.AdminRolePermissionDao;
import com.sw.urs.model.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionDao adminRolePermissionDao;

    /**
     * 添加角色的权限
     * @param adminRolePermission
     * @return
     */
    public int addAdminRolePermission(AdminRolePermission adminRolePermission) {
        return adminRolePermissionDao.addAdminRolePermission(adminRolePermission);
    }

    /**
     * 查询rid角色拥有的权限
     * @param rid
     * @return
     */
    public HashSet<String> selectByRid(int rid) {
        return adminRolePermissionDao.selectByRid(rid);
    }

    /**
     * 删除rid角色对应权限
     * @param rid
     * @param permissionId
     * @return
     */
    public int deleteAdminRolePermission(int rid,int permissionId) {
        return adminRolePermissionDao.deleteAdminRolePermission(rid,permissionId);
    }
}
