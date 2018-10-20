package com.sw.urs.controller;

import com.github.pagehelper.PageInfo;
import com.sw.urs.model.AdminPermission;
import com.sw.urs.model.MyResponse;
import com.sw.urs.service.AdminPermissionService;
import com.sw.urs.util.MyResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminPermission",produces = "application/json;charset=UTF-8")
public class AdminPermissionController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AdminPermissionService adminPermissionService;

    /**
     * 添加adminPermission权限
     * @param adminPermission
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public MyResponse addAdminPermission(@Valid AdminPermission adminPermission, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return adminPermissionService.addAdminPermission(adminPermission) == 1 ? MyResponseUtil.success("添加成功") : MyResponseUtil.error("添加失败");
        } catch (Exception e) {
            logger.error("添加异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询分页adminPermission信息
     * @param currentPage 当前页
     * @param pageSize 每页数量
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public MyResponse selectPageAdminPermission(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        try {
            PageInfo<AdminPermission> adminPermissionPageInfo = adminPermissionService.selectPageAdminPermission(currentPage,pageSize);
            return adminPermissionPageInfo == null ? MyResponseUtil.error("无角色数据") : MyResponseUtil.success(adminPermissionPageInfo);
        } catch (Exception e) {
            logger.error("查询adminPermission异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询全部adminPermission
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MyResponse selectAllAdminPermission() {
        try {
            List<AdminPermission> adminPermissions = adminPermissionService.selectAllAdminPermission();
            return adminPermissions == null ? MyResponseUtil.error("无权限数据") : MyResponseUtil.success(adminPermissions);
        } catch (Exception e) {
            logger.error("查询全部adminPermission异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id查询adminPermission信息
     * @param adminPermissionId
     * @return
     */
    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public MyResponse selectAdminPermissionById(@RequestParam("adminPermissionId") int adminPermissionId) {
        try {
            AdminPermission adminPermission = adminPermissionService.selectAdminPermissionById(adminPermissionId);
            return adminPermission == null ? MyResponseUtil.error("该权限不存在") : MyResponseUtil.success(adminPermission);
        } catch (Exception e) {
            logger.error("根据id查询adminPermission异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 修改adminPermission信息
     * @param adminPermission
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public MyResponse updateAdminPermission(@Valid AdminPermission adminPermission, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return adminPermissionService.updateAdminPermission(adminPermission) == 1 ? MyResponseUtil.success("修改成功") : MyResponseUtil.error("修改失败");
        } catch (Exception e) {
            logger.error("修改异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id禁用adminPermission
     * @param id
     * @return
     */
    @RequestMapping(value = "/forbid",method = RequestMethod.GET)
    public MyResponse forbidAdminPermission(int id) {
        try {
            return adminPermissionService.forbidAdminPermission(id) == 1 ? MyResponseUtil.success("禁用成功") : MyResponseUtil.error("禁用失败");
        } catch (Exception e) {
            logger.error("禁用异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id解除对adminPermission的禁用
     * @param id
     * @return
     */
    @RequestMapping(value = "/unForbidden",method = RequestMethod.GET)
    public MyResponse unForbiddenAdminPermission(int id) {
        try {
            return adminPermissionService.unForbiddenAdminPermission(id) == 1 ? MyResponseUtil.success("解除禁用成功") : MyResponseUtil.error("解除禁用失败");
        } catch (Exception e) {
            logger.error("解除禁用异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id删除adminPermission
     * @param id
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public MyResponse deleteAdminPermissionById(int id) {
        try {
            return adminPermissionService.deleteAdminPermissionById(id) == 1 ? MyResponseUtil.success("删除成功") : MyResponseUtil.error("删除失败");
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }
}