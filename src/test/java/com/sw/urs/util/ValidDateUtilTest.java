package com.sw.urs.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidDateUtilTest {

    @Test
    public void isValidDate() {
        String smallDate1 = "2018-10-18";
        String bigDate1 = "2018-10-21";
        boolean flag1 = ValidDateUtil.isValidDate(smallDate1,bigDate1);
        assertTrue(flag1);
        String smallDate2 = "2018-10-81";
        String bigDate2 = "avsdsdsd";
        boolean flag2 = ValidDateUtil.isValidDate(smallDate2,bigDate2);
        assertFalse(flag2);
    }
}