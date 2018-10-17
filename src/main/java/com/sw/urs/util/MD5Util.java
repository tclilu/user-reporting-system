package com.sw.urs.util;

import org.springframework.util.DigestUtils;

public class MD5Util {
    /**
     * md5加密，利用spring框架自带MD5加密
     * @param str
     * @return
     */
    public static String md5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
