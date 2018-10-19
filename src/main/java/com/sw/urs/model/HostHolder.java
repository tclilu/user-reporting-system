package com.sw.urs.model;

import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private static ThreadLocal<Admin> adminThreadLocal = new ThreadLocal<Admin>();

    /**
     * 获取当前admin
     * @return
     */
    public Admin getAdmin() {
        return adminThreadLocal.get();
    }

    /**
     * 设置admin
     * @param admin
     */
    public void setAdmin(Admin admin) {
        adminThreadLocal.set(admin);
    }

    /**
     * 清除admin
     */
    public void clear() {
        adminThreadLocal.remove();
    }
}
