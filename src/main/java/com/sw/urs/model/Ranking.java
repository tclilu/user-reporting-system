package com.sw.urs.model;

/**
 * 统计排名
 */
public class Ranking {
    // 排名的条件（例如：客户的数量，客户的消费总额）
    private String condition;
    // 销售的姓名（昵称）
    private String adminNickName;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAdminNickName() {
        return adminNickName;
    }

    public void setAdminNickName(String adminNickName) {
        this.adminNickName = adminNickName;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "condition='" + condition + '\'' +
                ", adminNickName='" + adminNickName + '\'' +
                '}';
    }
}
