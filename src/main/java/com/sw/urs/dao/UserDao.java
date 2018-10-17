package com.sw.urs.dao;

import com.sw.urs.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " username,sex,description,email,add_time,status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    /**
     * 添加客户
     * @param user
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values(#{username},#{sex},#{description},#{email},#{addTime},#{status})"})
    int addUser(User user);

    /**
     * 根据id查询客户
     * @param id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where id=#{id}"})
    User selectById(int id);

    /**
     * 修改客户信息
     * @param user
     */
    @Update({"update ",TABLE_NAME," set username=#{username},sex=#{sex},description=#{description},email=#{email},status=#{status} where id=#{id}"})
    int updateUser(User user);

    /**
     * 根据id删除客户
     * @param id 客户id
     */
    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    int deleteById(int id);
}
