package com.sw.urs.dao;

import com.sw.urs.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " username,sex,description,email,add_time,status ";
    String SELECT_FIELDS = " id " + INSERT_FIELDS;

    /**
     * 添加用户接口
     * @param user
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values(#{username},#{sex},#{description},#{email},#{add_time},#{status})"})
    int addUser(User user);
}
