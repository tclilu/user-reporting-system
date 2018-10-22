package com.sw.urs.dao;

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
public class RankingDaoTest {
    @Autowired
    RankingDao rankingDao;

    /**
     * 本周客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisWeek() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserCountByThisWeek();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本月客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisMonth() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserCountByThisMonth();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本年客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisYear() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserCountByThisYear();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本周客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisWeek() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserPayByThisWeek();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本月客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisMonth() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserPayByThisMonth();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 本年客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisYear() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserPayByThisYear();
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 任意日期范围客户总数排名
     * @throws Exception
     */
    @Test
    public void rankUserCountByDateRange() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserCountByDateRange("2018-10-18","2018-10-21");
        assertNotNull(rankings);
        System.out.println(rankings);
    }

    /**
     * 任意日期范围客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByDateRange() throws Exception {
        List<Ranking> rankings = rankingDao.rankUserPayByDateRange("2018-10-18","2018-10-21");
        assertNotNull(rankings);
        System.out.println(rankings);
    }
}