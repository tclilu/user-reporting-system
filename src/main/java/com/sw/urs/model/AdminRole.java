package com.sw.urs.model;

/**
 * 系统角色类
 */
public class AdminRole {
    private int id;
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
