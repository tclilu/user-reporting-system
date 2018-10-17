package com.sw.urs.dao;

import com.sw.urs.model.AdminRole;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminRoleDao {
    String TABLE_NAME = " admin_role ";
    String INSERT_FIELDS = " role_name,status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    /**
     * 添加角色
     * @param adminRole
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values(#{roleName},#{status})"})
    int addAdminRole(AdminRole adminRole);

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ", TABLE_NAME," where id=#{id}"})
    AdminRole selectById(int id);

    /**
     * 修改角色信息
     * @param adminRole
     */
    @Update({"update ",TABLE_NAME," set role_name=#{roleName},status=#{status} where id=#{id}"})
    int updateAdminRole(AdminRole adminRole);

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    int deleteById(int id);
}