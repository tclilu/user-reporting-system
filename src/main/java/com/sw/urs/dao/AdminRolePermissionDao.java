package com.sw.urs.dao;

import com.sw.urs.model.AdminPermission;
import com.sw.urs.model.AdminRolePermission;
import org.apache.ibatis.annotations.*;

import java.util.HashSet;
import java.util.List;

@Mapper
public interface AdminRolePermissionDao {
    String TABLE_NAME = " admin_role_permission ";
    String FIELDS = " role_id,permission_id ";

    /**
     * 添加角色权限
     * @param adminRolePermission
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",FIELDS,") values(#{roleId},#{permissionId})"})
    int addAdminRolePermission(AdminRolePermission adminRolePermission);

    /**
     * 根据角色id查询该角色拥有的权限的路由地址集合
     * @param rid
     * @return
     */
    @Select({"select api_address from admin_permission,admin_role_permission where #{rid}=admin_role_permission.role_id and admin_permission.id=admin_role_permission.permission_id"})
    HashSet<String> selectByRid(int rid);

    /**
     * 删除rid对应角色的对应权限
     * @param rid
     * @param permissionId
     * @return
     */
    @Delete({"delete from ",TABLE_NAME," where role_id=#{rid} and permission_id=#{permissionId}"})
    int deleteAdminRolePermission(@Param("rid") int rid,@Param("permissionId") int permissionId);
}
