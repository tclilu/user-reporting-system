package com.sw.urs.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 客户类
 */
public class User {
    private int id;
    @NotBlank(message = "客户名不能为空")
    private String username;
    private int sex;
    @Size(min = 1,max = 255,message = "客户情况描述长度在1~255之间")
    private String description;
    @Email
    private String email;
    private Date addTime;
    private String status;
    private int adminId;
    private int payMoney;
    private String nickName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", addTime=" + addTime +
                ", status='" + status + '\'' +
                ", adminId=" + adminId +
                ", payMoney=" + payMoney +
                '}';
    }
}
