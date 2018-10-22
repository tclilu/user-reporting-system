package com.sw.urs.service;

import com.sw.urs.dao.RankingDao;
import com.sw.urs.model.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return addPosition(rankingDao.rankUserCountByThisWeek());
    }

    /**
     * 本月客户总数排名
     * @return
     */
    public List<Ranking> rankUserCountByThisMonth() {
        return addPosition(rankingDao.rankUserCountByThisMonth());
    }

    /**
     * 本年客户总数排名
     * @return
     */
    public List<Ranking> rankUserCountByThisYear() {
        return addPosition(rankingDao.rankUserCountByThisYear());
    }

    /**
     * 任意日期范围客户总数排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    public List<Ranking> rankUserCountByDateRange(String smallDate,String bigDate) {
        return addPosition(rankingDao.rankUserCountByDateRange(smallDate,bigDate));
    }

    /**
     * 本周客户消费总金额排名
     * @return
     */
    public List<Ranking> rankUserPayByThisWeek() {
        return addPosition(rankingDao.rankUserPayByThisWeek());
    }

    /**
     * 本月客户消费总金额排名
     * @return
     */
    public List<Ranking> rankUserPayByThisMonth() {
        return addPosition(rankingDao.rankUserPayByThisMonth());
    }

    /**
     * 本年客户消费总金额排名
     * @return
     */
    public List<Ranking> rankUserPayByThisYear() {
        return addPosition(rankingDao.rankUserPayByThisYear());
    }

    /**
     * 任意日期范围客户消费总金额排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    public List<Ranking> rankUserPayByDateRange(String smallDate, String bigDate) {
        return addPosition(rankingDao.rankUserPayByDateRange(smallDate,bigDate));
    }

    /**
     * 添加排名，排第几名的字段信息
     * 未考虑的问题：如果客户数量（或客户总消费）相同，并列排名
     * @param rankingList
     * @return
     */
    private List<Ranking> addPosition(List<Ranking> rankingList) {
        for (int i = 0;i < rankingList.size();i++) {
            rankingList.get(i).setPosition(i + 1);
        }
        return rankingList;
    }
}