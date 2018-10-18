package com.sw.urs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sw.urs.dao.AdminRoleDao;
import com.sw.urs.exception.MyResponseException;
import com.sw.urs.model.AdminRole;
import com.sw.urs.model.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDao adminRoleDao;

    /**
     * 添加系统角色
     * @param adminRole
     * @return
     */
    public int addAdminRole(AdminRole adminRole) {
        // 过滤可能的HTML标签
        adminRole.setRoleName(HtmlUtils.htmlEscape(adminRole.getRoleName()));
        return adminRoleDao.addAdminRole(adminRole);
    }

    /**
     * 查询分页系统角色
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<AdminRole> selectPageAdminRole(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<AdminRole> adminRoles = adminRoleDao.selectAdminRoles();
        PageInfo<AdminRole> adminRolePageInfo = new PageInfo<>(adminRoles);
        return adminRolePageInfo;
    }

    /**
     * 查询全部系统角色
     * @return
     */
    public List<AdminRole> selectAllAdminRole() {
        return adminRoleDao.selectAdminRoles();
    }

    /**
     * 根据角色id查询角色信息
     * @param id
     * @return
     */
    public AdminRole selectAdminRoleById(int id) {
        return adminRoleDao.selectById(id);
    }

    /**
     * 修改角色信息
     * @param adminRole
     * @return
     */
    public int updateAdminRole(AdminRole adminRole) {
        if (adminRole.getId() == 1) {
            throw new MyResponseException(ResponseCode.THIS_IS_ADMIN);
        }
        return adminRoleDao.updateAdminRole(adminRole);
    }

    /**
     * 禁用系统角色
     * @param id
     * @return
     */
    public int forbidAdminRole(int id) {
        if (id == 1) {
            throw new MyResponseException(ResponseCode.THIS_IS_ADMIN);
        }
        return adminRoleDao.updateStatus(id,1);
    }

    /**
     * 解除角色的禁用
     * @param id
     * @return
     */
    public int unForbiddenAdminRole(int id) {
        if (id == 1) {
            throw new MyResponseException(ResponseCode.THIS_IS_ADMIN);
        }
        return adminRoleDao.updateStatus(id,0);
    }

    /**
     * 根据admin_role的id删除角色
     * @param id
     * @return
     */
    public int deleteAdminRoleById(int id) {
        if (id == 1) {
            throw new MyResponseException(ResponseCode.THIS_IS_ADMIN);
        }
        return adminRoleDao.deleteById(id);
    }
}
