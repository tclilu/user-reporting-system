package com.sw.urs.dao;

import com.sw.urs.model.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminDao {
    String TABLE_NAME = " admin ";
    String INSERT_FIELDS = " admin_name,password,salt,nick_name,tel,avatar,add_time,rid,status ";
    String CHECK_LOGIN_FIELDS = " id, " + INSERT_FIELDS;
    String SELECT_FIELDS = " id,admin_name,nick_name,tel,avatar,add_time,rid,status ";

    /**
     * 添加管理人员
     * @param admin
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,
            ") values(#{adminName},#{password},#{salt},#{nickName},#{tel},#{avatar},#{addTime},#{rid},#{status})"})
    int addAdmin(Admin admin);

    /**
     * 登录验证查询
     * @param adminName
     * @return
     */
    @Select({"select ",CHECK_LOGIN_FIELDS," from ",TABLE_NAME," where admin_name=#{adminName}"})
    Admin selectForLogin(String adminName);

    /**
     * 按id降序排列查询所有Admin
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," order by id desc"})
    List<Admin> selectAdmins();

    /**
     * 根据id查询管理人员信息
     * @param id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where id=#{id}"})
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "admin_name",property = "adminName"),
            @Result(column = "nick_name",property = "nickName"),
            @Result(column = "tel",property = "tel"),
            @Result(column = "avatar",property = "avatar"),
            @Result(column = "add_time",property = "addTime"),
            @Result(column = "rid",property = "rid"),
            @Result(column = "status",property = "status"),
    })
    Admin selectById(int id);

    /**
     * 根据管理人员登录名查询管理人员信息
     * @param adminName
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where admin_name=#{adminName}"})
    Admin selectByAdminName(String adminName);

    /**
     * 修改管理人员信息
     * @param admin
     */
    @Update({"update ",TABLE_NAME,
            " set password=#{password},salt=#{salt},nick_name=#{nickName},tel=#{tel},avatar=#{avatar},rid=#{rid},status=#{status} where id=#{id}"})
    int updateAdmin(Admin admin);

    /**
     * 修改admin状态
     * @param id
     * @param status
     * @return
     */
    @Update({"update ",TABLE_NAME," set status=#{status} where id=#{id}"})
    int updateStatus(@Param("id") int id,@Param("status") int status);

    /**
     * 根据id删除管理人员
     * @param id
     */
    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    int deleteById(int id);
}
