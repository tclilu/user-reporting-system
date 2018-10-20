package com.sw.urs.controller;

import com.github.pagehelper.PageInfo;
import com.sw.urs.model.AdminRole;
import com.sw.urs.model.MyResponse;
import com.sw.urs.service.AdminRoleService;
import com.sw.urs.util.MyResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminRole",produces = "application/json;charset=UTF-8")
public class AdminRoleController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AdminRoleService adminRoleService;

    /**
     * 添加adminRole角色
     * @param adminRole
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public MyResponse addAdminRole(@Valid AdminRole adminRole, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return adminRoleService.addAdminRole(adminRole) == 1 ? MyResponseUtil.success("添加成功") : MyResponseUtil.error("添加失败");
        } catch (Exception e) {
            logger.error("添加adminRole异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询分页adminRole信息
     * @param currentPage 当前页
     * @param pageSize 每页数量
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public MyResponse selectPageAdminRole(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        try {
            PageInfo<AdminRole> adminRolePageInfo = adminRoleService.selectPageAdminRole(currentPage,pageSize);
            return adminRolePageInfo == null ? MyResponseUtil.error("无角色数据") : MyResponseUtil.success(adminRolePageInfo);
        } catch (Exception e) {
            logger.error("查询adminRole异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询全部adminRole
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MyResponse selectAllAdminRole() {
        try {
            List<AdminRole> adminRoles = adminRoleService.selectAllAdminRole();
            return adminRoles == null ? MyResponseUtil.error("无角色数据") : MyResponseUtil.success(adminRoles);
        } catch (Exception e) {
            logger.error("查询全部adminRole异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id查询adminRole信息
     * @param adminRoleId
     * @return
     */
    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public MyResponse selectAdminRoleById(@RequestParam("adminRoleId") int adminRoleId) {
        try {
            AdminRole adminRole = adminRoleService.selectAdminRoleById(adminRoleId);
            return adminRole == null ? MyResponseUtil.error("该角色不存在") : MyResponseUtil.success(adminRole);
        } catch (Exception e) {
            logger.error("根据id查询adminRole异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 修改adminRole信息
     * @param adminRole
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public MyResponse updateAdminRole(@Valid AdminRole adminRole, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return adminRoleService.updateAdminRole(adminRole) == 1 ? MyResponseUtil.success("修改成功") : MyResponseUtil.error("修改失败");
        } catch (Exception e) {
            logger.error("修改adminRole异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id禁用adminRole
     * @param id
     * @return
     */
    @RequestMapping(value = "/forbid",method = RequestMethod.GET)
    public MyResponse forbidAdminRole(int id) {
        try {
            return adminRoleService.forbidAdminRole(id) == 1 ? MyResponseUtil.success("禁用成功") : MyResponseUtil.error("禁用失败");
        } catch (Exception e) {
            logger.error("禁用adminRole异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id解除对adminRole的禁用
     * @param id
     * @return
     */
    @RequestMapping(value = "/unForbidden",method = RequestMethod.GET)
    public MyResponse unForbiddenAdminRole(int id) {
        try {
            return adminRoleService.unForbiddenAdminRole(id) == 1 ? MyResponseUtil.success("解除禁用成功") : MyResponseUtil.error("解除禁用失败");
        } catch (Exception e) {
            logger.error("解除禁用异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id删除adminRole
     * @param id
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public MyResponse deleteAdminRoleById(int id) {
        try {
            return adminRoleService.deleteAdminRoleById(id) == 1 ? MyResponseUtil.success("删除成功") : MyResponseUtil.error("删除失败");
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }
}
