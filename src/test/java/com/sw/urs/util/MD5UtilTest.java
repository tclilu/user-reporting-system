package com.sw.urs.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MD5UtilTest {

    /**
     * md5加密测试
     */
    @Test
    public void md5() {
        System.out.println(MD5Util.md5("123456"));
    }
}