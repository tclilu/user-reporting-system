package com.sw.urs.util;

import com.sw.urs.model.ResponseCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyResponseUtilTest {
    private Logger logger = LoggerFactory.getLogger(MyResponseUtilTest.class);

    /**
     * success测试
     */
    @Test
    public void success() {
        assertNotNull(MyResponseUtil.success("ok"));
        System.out.println(MyResponseUtil.success("ok"));
    }

    /**
     * info测试
     */
    @Test
    public void info() {
        assertNotNull(MyResponseUtil.info(ResponseCode.SUCCESS,"ok"));
        System.out.println(MyResponseUtil.info(ResponseCode.SUCCESS,"ok"));
    }
}