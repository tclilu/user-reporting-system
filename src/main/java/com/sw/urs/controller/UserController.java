package com.sw.urs.controller;

import com.github.pagehelper.PageInfo;
import com.sw.urs.model.MyResponse;
import com.sw.urs.model.ResponseCode;
import com.sw.urs.model.User;
import com.sw.urs.service.UserService;
import com.sw.urs.util.MyResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user",produces = "application/json;charset=UTF-8")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    /**
     * 前端录入客户信息接口
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public MyResponse addUser(@Valid User user,BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return userService.addUser(user) == 1 ? MyResponseUtil.success("添加成功") : MyResponseUtil.error("添加失败");
        } catch (Exception e) {
            logger.error("添加异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询分页客户信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public MyResponse selectPageUser(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        try {
            PageInfo<User> userPageInfo = userService.selectPageUser(currentPage,pageSize);
            return userPageInfo == null ? MyResponseUtil.error("无数据") : MyResponseUtil.success(userPageInfo);
        } catch (Exception e) {
            logger.error("查询分页user异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 查询全部User
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MyResponse selectAllUser() {
        try {
            List<User> users = userService.selectAllUser();
            return users == null ? MyResponseUtil.error("无数据") : MyResponseUtil.success(users);
        } catch (Exception e) {
            logger.error("查询全部user异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id查询user信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public MyResponse selectUserById(int id) {
        try {
            User user = userService.selectUserById(id);
            return user == null ? MyResponseUtil.error("该user不存在") : MyResponseUtil.success(user);
        } catch (Exception e) {
            logger.error("根据id查询user异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 修改user信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public MyResponse updateUser(@Valid User user,BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return MyResponseUtil.error(bindingResult.getFieldError().getDefaultMessage());
            }
            return userService.updateUser(user) == 1 ? MyResponseUtil.success("修改成功") : MyResponseUtil.error("修改失败");
        } catch (Exception e) {
            logger.error("修改user异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 根据id删除user信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public MyResponse deleteUserById(int id) {
        try {
            return userService.deleteUserById(id) == 1 ? MyResponseUtil.success("删除成功") : MyResponseUtil.error("删除失败");
        } catch (Exception e) {
            logger.error("删除user异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }
}
