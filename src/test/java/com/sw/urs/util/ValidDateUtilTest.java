package com.sw.urs.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidDateUtilTest {

    @Test
    public void isValidDate() {
        System.out.println(ValidDateUtil.isValidDate("12232323","2222"));
        System.out.println(ValidDateUtil.isValidDate("avcs-12-a","33333"));
        System.out.println(ValidDateUtil.isValidDate("2018-12-12","2017-11-11"));
    }
}