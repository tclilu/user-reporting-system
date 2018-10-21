package com.sw.urs.service;

import com.sw.urs.dao.RankingDao;
import com.sw.urs.model.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RankingService {
    @Autowired
    RankingDao rankingDao;

    /**
     * 本周客户总数排名
     * @return
     */
    public List<Ranking> rankUserCountByThisWeek() {
        return rankingDao.rankUserCountByThisWeek();
    }

    /**
     * 本月客户总数排名
     * @return
     */
    public List<Ranking> rankUserCountByThisMonth() {
        return rankingDao.rankUserCountByThisMonth();
    }

    /**
     * 本年客户总数排名
     * @return
     */
    public List<Ranking> rankUserCountByThisYear() {
        return rankingDao.rankUserCountByThisYear();
    }

    /**
     * 任意日期范围客户总数排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    public List<Ranking> rankUserCountByDateRange(Date smallDate,Date bigDate) {
        return rankingDao.rankUserCountByDateRange(smallDate,bigDate);
    }

    /**
     * 本周客户消费总金额排名
     * @return
     */
    public List<Ranking> rankUserPayByThisWeek() {
        return rankingDao.rankUserPayByThisWeek();
    }

    /**
     * 本月客户消费总金额排名
     * @return
     */
    public List<Ranking> rankUserPayByThisMonth() {
        return rankingDao.rankUserPayByThisMonth();
    }

    /**
     * 本年客户消费总金额排名
     * @return
     */
    public List<Ranking> rankUserPayByThisYear() {
        return rankingDao.rankUserPayByThisYear();
    }

    /**
     * 任意日期范围客户消费总金额排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    public List<Ranking> rankUserPayByDateRange(Date smallDate, Date bigDate) {
        return rankingDao.rankUserPayByDateRange(smallDate,bigDate);
    }
}