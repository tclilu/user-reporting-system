package com.sw.urs.dao;

import com.sw.urs.model.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminDao {
    String TABLE_NAME = " admin ";
    String INSERT_FIELDS = " admin_name,password,salt,nick_name,tel,avatar,add_time,rid,status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    /**
     * 添加管理人员
     * @param admin
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,
            ") values(#{adminName},#{password},#{salt},#{nickName},#{tel},#{avatar},#{addTime},#{rid},#{status})"})
    int addAdmin(Admin admin);

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
            " set admin_name=#{adminName},password=#{password},salt=#{salt},nick_name=#{nickName},tel=#{tel},avatar=#{avatar},rid=#{rid},status=#{status} where id=#{id}"})
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
