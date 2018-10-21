package com.sw.urs.dao;

import com.sw.urs.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    String TABLE_NAME = " user ";
    String FOREIGN_KEY_TABLE_NAME = " admin ";
    String INSERT_FIELDS = " username,sex,description,email,add_time,status,admin_id,pay_money ";
    String SELECT_FIELDS = " user.id,user.username,user.sex,user.description,user.email,user.add_time,user.status,user.pay_money,user.admin_id,admin.nick_name";

    /**
     * 添加客户
     * @param user
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values(#{username},#{sex},#{description},#{email},#{addTime},#{status},#{adminId},#{payMoney})"})
    int addUser(User user);

    /**
     * 管理员查询所有User(按user.id降序)
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," inner join ",FOREIGN_KEY_TABLE_NAME," on user.admin_id=admin.id order by user.id desc "})
    List<User> adminSelectUsers();

    /**
     * 销售人员查询User(只能看到自己添加的User)
     * @param adminId
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," inner join ",FOREIGN_KEY_TABLE_NAME," on user.admin_id=admin.id where user.admin_id=#{adminId} order by user.id desc "})
    List<User> saleSelectUsers(int adminId);

    /**
     * 根据id查询客户
     * @param id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," inner join ",FOREIGN_KEY_TABLE_NAME," on user.admin_id=admin.id where user.id=#{id}"})
    User selectById(int id);

    /**
     * 管理人员根据客户username模糊查询（查询全部）
     * @param usernameKeyword
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," inner join ",FOREIGN_KEY_TABLE_NAME," on user.admin_id=admin.id where user.username like #{usernameKeyword} order by user.id desc "})
    List<User> adminSelectLikeUsername(String usernameKeyword);

    /**
     * 销售人员根据客户username模糊查询（只能查自己添加的）
     * @param usernameKeyword
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," inner join ",FOREIGN_KEY_TABLE_NAME," on user.admin_id=admin.id where user.admin_id=#{adminId} and user.username like #{usernameKeyword} order by user.id desc "})
    List<User> saleSelectLikeUsername(@Param("usernameKeyword") String usernameKeyword,@Param("adminId") int adminId);

    /**
     * 修改客户信息
     * @param user
     */
    @Update({"update ",TABLE_NAME," set username=#{username},sex=#{sex},description=#{description},email=#{email},status=#{status},pay_money=#{payMoney} where id=#{id}"})
    int updateUser(User user);

    /**
     * 根据id删除客户
     * @param id 客户id
     */
    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    int deleteById(int id);
}
