package com.sw.urs.model;

import com.sun.xml.internal.ws.api.model.MEP;

import javax.validation.constraints.NotBlank;

/**
 * 权限表
 */
public class AdminPermission {
    private int id;
    private int parentId;
    @NotBlank(message = "权限名不能为空")
    private String permissionName;
    @NotBlank(message = "权限路由地址不能为空")
    private String apiAddress;
    private int isHidden;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getApiAddress() {
        return apiAddress;
    }

    public void setApiAddress(String apiAddress) {
        this.apiAddress = apiAddress;
    }

    public int getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(int isHidden) {
        this.isHidden = isHidden;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminPermission{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", permissionName='" + permissionName + '\'' +
                ", apiAddress='" + apiAddress + '\'' +
                ", isHidden=" + isHidden +
                ", status=" + status +
                '}';
    }
}
