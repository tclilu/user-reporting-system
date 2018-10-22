package com.sw.urs.service;

import com.sw.urs.model.Ranking;
import com.sw.urs.util.ValidDateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        List<Ranking> rankings = rankingService.rankUserCountByThisWeek();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本月客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisMonth() throws Exception {
        List<Ranking> rankings = rankingService.rankUserCountByThisMonth();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本年客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisYear() throws Exception {
        List<Ranking> rankings = rankingService.rankUserCountByThisYear();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 任意日期范围客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByDateRange() throws Exception {
        String smallDate1 = "2018-10-18";
        String bigDate1 = "2018-10-21";
        boolean flag1 = ValidDateUtil.isValidDate(smallDate1,bigDate1);
        assertTrue(flag1);
        String smallDate2 = "2018-10-81";
        String bigDate2 = "avsdsdsd";
        boolean flag2 = ValidDateUtil.isValidDate(smallDate2,bigDate2);
        assertFalse(flag2);
        List<Ranking> rankings = rankingService.rankUserCountByDateRange(smallDate1,bigDate1);
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本周客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisWeek() throws Exception {
        List<Ranking> rankings = rankingService.rankUserPayByThisWeek();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本月客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisMonth() throws Exception {
        List<Ranking> rankings = rankingService.rankUserPayByThisMonth();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本年客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisYear() throws Exception {
        List<Ranking> rankings = rankingService.rankUserPayByThisYear();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 任意日期范围客户消费总金额排名测试
     * @throws Exception
     */
    @Test
    public void rankUserPayByDateRange() throws Exception {
        String smallDate1 = "2018-10-18";
        String bigDate1 = "2018-10-21";
        boolean flag1 = ValidDateUtil.isValidDate(smallDate1,bigDate1);
        assertTrue(flag1);
        String smallDate2 = "2018-10-81";
        String bigDate2 = "avsdsdsd";
        boolean flag2 = ValidDateUtil.isValidDate(smallDate2,bigDate2);
        assertFalse(flag2);
        List<Ranking> rankings = rankingService.rankUserPayByDateRange(smallDate1,bigDate1);
        assertNotNull(rankings);
        System.out.println(rankings);
    }
}