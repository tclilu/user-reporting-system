package com.sw.urs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RankingServiceTest {
    @Autowired
    RankingService rankingService;

    /**
     * 本周客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisWeek() throws Exception {
        System.out.println(rankingService.rankUserCountByThisWeek());
    }

    /**
     * 本月客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisMonth() throws Exception {
        System.out.println(rankingService.rankUserCountByThisMonth());
    }

    /**
     * 本年客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisYear() throws Exception {
        System.out.println(rankingService.rankUserCountByThisYear());
    }

    /**
     * 任意日期范围客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByDateRange() throws Exception {
        System.out.println(rankingService.rankUserCountByDateRange(new Date(),new Date()));
    }

    /**
     * 本周客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisWeek() throws Exception {
        System.out.println(rankingService.rankUserPayByThisWeek());
    }

    /**
     * 本月客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisMonth() throws Exception {
        System.out.println(rankingService.rankUserPayByThisMonth());
    }

    /**
     * 本年客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisYear() throws Exception {
        System.out.println(rankingService.rankUserPayByThisYear());
    }

    /**
     * 任意日期范围客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByDateRange() throws Exception {
        System.out.println(rankingService.rankUserPayByDateRange(new Date(),new Date()));
    }
}