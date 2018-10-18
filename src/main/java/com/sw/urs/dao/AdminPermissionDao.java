package com.sw.urs.dao;

import com.sw.urs.model.AdminPermission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminPermissionDao {
    String TABLE_NAME = " admin_permission ";
    String INSERT_FIELDS = " parent_id,permission_name,api_address,is_hidden,status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    /**
     * 添加权限
     * @param adminPermission
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values(#{parentId},#{permissionName},#{apiAddress},#{isHidden},#{status})"})
    int addAdminPermission(AdminPermission adminPermission);

    /**
     * 按id降序排列查询所有AdminPermission
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," order by id desc"})
    List<AdminPermission> selectAdminPermissions();

    /**
     * 根据id查询权限
     * @param id
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where id=#{id}"})
    AdminPermission selectById(int id);

    /**
     * 修改权限信息
     * @param adminPermission
     * @return
     */
    @Update({"update ",TABLE_NAME,
            " set parent_id=#{parentId},permission_name=#{permissionName},api_address=#{apiAddress},is_hidden=#{isHidden},status=#{status} where id=#{id}"})
    int updateAdminPermission(AdminPermission adminPermission);

    /**
     * 修改权限状态
     * @param id
     * @param status
     * @return
     */
    @Update({"update ",TABLE_NAME," set status=#{status} where id=#{id}"})
    int updateStatus(@Param("id") int id,@Param("status") int status);

    /**
     * 根据id删除权限
     * @param id
     * @return
     */
    @Delete({"delete from ",TABLE_NAME," where id=#{id}"})
    int deleteById(int id);
}
