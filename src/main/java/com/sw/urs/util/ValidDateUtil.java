package com.sw.urs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式校验工具类
 */
public class ValidDateUtil {
    /**
     * 判断字符串是否是一个格式为"yyyy-MM-dd"的字符串，且smallDate在bigDate之前
     * @param smallDate
     * @param bigDate
     * @return
     */
    public static boolean isValidDate(String smallDate,String bigDate) {
        boolean flag = true;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false，不宽松的验证日期
            sdf.setLenient(false);
            // 转换格式，出错则抛出异常
            Date small = sdf.parse(smallDate);
            Date big = sdf.parse(bigDate);
            // 日期比较，如果bigDate在smallDate之前，则不符合
            if (big.before(small)) {
                flag = false;
            }
        } catch (ParseException e) {
            flag = false;
        }
        return flag;
    }
}
