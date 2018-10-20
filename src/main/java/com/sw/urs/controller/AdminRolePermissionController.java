package com.sw.urs.controller;

import com.sw.urs.model.AdminRolePermission;
import com.sw.urs.model.MyResponse;
import com.sw.urs.service.AdminRolePermissionService;
import com.sw.urs.util.MyResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;

@RestController
@RequestMapping(value = "/admin/adminRolePermission",produces = "application/json;charset=UTF-8")
public class AdminRolePermissionController {
    private static final Logger logger = LoggerFactory.getLogger(AdminRolePermissionController.class);

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    /**
     * 给角色分配权限
     * @param adminRolePermission
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public MyResponse addAdminRolePermission(@Valid AdminRolePermission adminRolePermission, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return adminRolePermissionService.addAdminRolePermission(adminRolePermission) == 1 ? MyResponseUtil.success("添加成功") : MyResponseUtil.error("添加失败");
        } catch (Exception e) {
            logger.error("添加异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询rid对应角色拥有的权限
     * @param rid
     * @return
     */
    @RequestMapping(value = "/rid",method = RequestMethod.GET)
    public MyResponse selectByRid(@RequestParam("rid") int rid) {
        try {
            HashSet<String> permissions = adminRolePermissionService.selectByRid(rid);
            return permissions.isEmpty() ? MyResponseUtil.error("该角色无任何权限") : MyResponseUtil.success(permissions);
        } catch (Exception e) {
            logger.error("查询异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 删除rid角色对应权限
     * @param rid 角色id
     * @param permissionId 权限id
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public MyResponse deleteAdminRolePermission(@RequestParam("rid") int rid,@RequestParam("permissionId") int permissionId) {
        try {
            return adminRolePermissionService.deleteAdminRolePermission(rid,permissionId) == 1 ? MyResponseUtil.success("删除成功") : MyResponseUtil.error("删除失败");
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }
}
