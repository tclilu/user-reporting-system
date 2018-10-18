package com.sw.urs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sw.urs.dao.UserDao;
import com.sw.urs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /**
     * 添加User
     * @param user
     * @return
     */
    public int addUser(User user) {
        // 过滤可能的HTML标签
        user.setUsername(HtmlUtils.htmlEscape(user.getUsername()));
        user.setDescription(HtmlUtils.htmlEscape(user.getDescription()));
        return userDao.addUser(user);
    }

    /**
     * 查询分页User
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<User> selectPageUser(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> users = userDao.selectUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    /**
     * 查询所有User
     * @return
     */
    public List<User> selectAllUser() {
        return userDao.selectUsers();
    }

    /**
     * 根据User的id查询user信息
     * @param id
     * @return
     */
    public User selectUserById(int id) {
        return userDao.selectById(id);
    }

    /**
     * 修改user信息
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 根据id删除User
     * @param id
     * @return
     */
    public int deleteUserById(int id) {
        return userDao.deleteById(id);
    }
}
