package com.sw.urs.controller;

import com.github.pagehelper.PageInfo;
import com.sw.urs.model.Admin;
import com.sw.urs.model.MyResponse;
import com.sw.urs.service.AdminService;
import com.sw.urs.util.MyResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/admin",produces = "application/json;charset=UTF-8")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AdminService adminService;

    /**
     * 不开放管理员注册功能，必须由已有管理员手动添加
     * @param adminName
     * @param password
     * @param rid
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public MyResponse addAdmin(@RequestParam("adminName") String adminName,
                               @RequestParam("password") String password,
                               @RequestParam("rid") int rid) {
        try {
            return adminService.addAdmin(adminName,password,rid) == 1 ? MyResponseUtil.success("添加成功") : MyResponseUtil.error("添加失败");
        } catch (Exception e) {
            logger.error("添加异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据adminName查询admin信息
     * @param adminName
     * @return
     */
    @RequestMapping(value = "/adminName",method = RequestMethod.GET)
    public MyResponse selectByAdminName(String adminName) {
        try {
            Admin admin = adminService.selectByAdminName(adminName);
            return admin == null ? MyResponseUtil.error("无该人员") : MyResponseUtil.success(admin);
        } catch (Exception e) {
            logger.error("查询异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询分页admin信息
     * @param currentPage 当前页
     * @param pageSize 每页数量
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public MyResponse selectPageAdmin(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        try {
            PageInfo<Admin> adminPageInfo = adminService.selectPageAdmin(currentPage,pageSize);
            return adminPageInfo == null ? MyResponseUtil.error("无数据") : MyResponseUtil.success(adminPageInfo);
        } catch (Exception e) {
            logger.error("查询分页admin异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询全部admin
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MyResponse selectAllAdmin() {
        try {
            List<Admin> admins = adminService.selectAllAdmin();
            return admins == null ? MyResponseUtil.error("无数据") : MyResponseUtil.success(admins);
        } catch (Exception e) {
            logger.error("查询全部admin异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id查询admin信息
     * @param adminId
     * @return
     */
    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public MyResponse selectAdminById(@RequestParam("adminId") int adminId) {
        try {
            Admin admin = adminService.selectAdminById(adminId);
            return admin == null ? MyResponseUtil.error("该admin不存在") : MyResponseUtil.success(admin);
        } catch (Exception e) {
            logger.error("根据id查询admin异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 修改admin信息
     * @param admin
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public MyResponse updateAdmin(@Valid Admin admin, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return adminService.updateAdmin(admin) == 1 ? MyResponseUtil.success("修改成功") : MyResponseUtil.error("修改失败");
        } catch (Exception e) {
            logger.error("修改admin异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id禁用admin
     * @param id
     * @return
     */
    @RequestMapping(value = "/forbid",method = RequestMethod.GET)
    public MyResponse forbidAdmin(int id) {
        try {
            return adminService.forbidAdmin(id) == 1 ? MyResponseUtil.success("禁用成功") : MyResponseUtil.error("禁用失败");
        } catch (Exception e) {
            logger.error("禁用admin异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id解除对admin的禁用
     * @param id
     * @return
     */
    @RequestMapping(value = "/unForbidden",method = RequestMethod.GET)
    public MyResponse unForbiddenAdmin(int id) {
        try {
            return adminService.unForbiddenAdmin(id) == 1 ? MyResponseUtil.success("解除禁用成功") : MyResponseUtil.error("解除禁用失败");
        } catch (Exception e) {
            logger.error("解除禁用异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id删除admin
     * @param id
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public MyResponse deleteAdminById(int id) {
        try {
            return adminService.deleteAdminById(id) == 1 ? MyResponseUtil.success("删除成功") : MyResponseUtil.error("删除失败");
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }
}
