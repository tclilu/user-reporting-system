package com.sw.urs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sw.urs.dao.UserDao;
import com.sw.urs.model.HostHolder;
import com.sw.urs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    HostHolder hostHolder;

    /**
     * 添加User
     * @param user
     * @return
     */
    public int addUser(User user) {
        // 过滤可能的HTML标签
        user.setUsername(HtmlUtils.htmlEscape(user.getUsername()));
        user.setDescription(HtmlUtils.htmlEscape(user.getDescription()));
        // 设置添加时间
        user.setAddTime(new Date());
        // 设置admin_id
        user.setAdminId(hostHolder.getAdmin().getId());
        return userDao.addUser(user);
    }

    /**
     * 查询分页User（管理员查询全部，销售人员只能查看自己添加的）
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageInfo<User> selectPageUser(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> users = null;
        if (hostHolder.getAdmin().getRid() == 1) {
            // 管理人员
            users = userDao.adminSelectUsers();
        } else {
            // 销售人员或其它
            users = userDao.saleSelectUsers(hostHolder.getAdmin().getId());
        }
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    /**
     * 查询所有User（管理员查询全部，销售人员只能查看自己添加的）
     * @return
     */
    public List<User> selectAllUser() {
        List<User> users = null;
        if (hostHolder.getAdmin().getRid() == 1) {
            users = userDao.adminSelectUsers();
        } else {
            users = userDao.saleSelectUsers(hostHolder.getAdmin().getId());
        }
        return users;
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
     * 根据客户username模糊查询
     * @param usernameKeyword
     * @return
     */
    public List<User> selectUserLikeUsername(String usernameKeyword) {
        List<User> users = null;
        if (hostHolder.getAdmin().getRid() == 1) {
            users = userDao.adminSelectLikeUsername("%" + usernameKeyword + "%");
        } else {
            users = userDao.saleSelectLikeUsername("%" + usernameKeyword + "%",hostHolder.getAdmin().getId());
        }
        return users;
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
