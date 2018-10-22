package com.sw.urs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        System.out.println(rankingDao.rankUserCountByThisWeek());
    }

    /**
     * 本月客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisMonth() throws Exception {
        System.out.println(rankingDao.rankUserCountByThisMonth());
    }

    /**
     * 本年客户总数排名测试
     * @throws Exception
     */
    @Test
    public void rankUserCountByThisYear() throws Exception {
        System.out.println(rankingDao.rankUserCountByThisYear());
    }

    /**
     * 本周客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisWeek() throws Exception {
        System.out.println(rankingDao.rankUserPayByThisWeek());
    }

    /**
     * 本月客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisMonth() throws Exception {
        System.out.println(rankingDao.rankUserPayByThisMonth());
    }

    /**
     * 本年客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByThisYear() throws Exception {
        System.out.println(rankingDao.rankUserPayByThisYear());
    }

    /**
     * 任意日期范围客户总数排名
     * @throws Exception
     */
    @Test
    public void rankUserCountByDateRange() throws Exception {
        System.out.println(rankingDao.rankUserCountByDateRange("2018-10-18","2018-10-21"));
    }

    /**
     * 任意日期范围客户消费总金额排名
     * @throws Exception
     */
    @Test
    public void rankUserPayByDateRange() throws Exception {
        System.out.println(rankingDao.rankUserPayByDateRange("2018-10-18","2018-10-21"));
    }
}