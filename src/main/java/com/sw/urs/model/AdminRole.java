package com.sw.urs.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * 系统角色类
 */
public class AdminRole {
    private int id;
    @Size(max = 10,message = "角色名长度只能在10以内，请检查输入")
    private String roleName;
    // 0正常，1禁用
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", status=" + status +
                '}';
    }
}
