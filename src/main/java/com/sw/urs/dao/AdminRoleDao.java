package com.sw.urs.dao;

import com.sw.urs.model.AdminRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

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
     * 按id降序排列查询所有AdminRole
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," order by id desc"})
    List<AdminRole> selectAdminRoles();

    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where id=#{id}"})
    AdminRole selectById(int id);

    /**
     * 修改角色信息
     * @param adminRole
     */
    @Update({"update ",TABLE_NAME," set role_name=#{roleName},status=#{status} where id=#{id}"})
    int updateAdminRole(AdminRole adminRole);

    /**
     * 修改admin_role状态
     * @param id
     * @param status
     * @return
     */
    @Update({"update ",TABLE_NAME," set status=#{status} where id=#{id}"})
    int updateStatus(@Param("id") int id,@Param("status") int status);

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    int deleteById(int id);
}