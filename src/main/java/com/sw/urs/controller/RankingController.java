package com.sw.urs.controller;

import com.sw.urs.model.MyResponse;
import com.sw.urs.service.RankingService;
import com.sw.urs.util.MyResponseUtil;
import com.sw.urs.util.ValidDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/",produces = "application/json;charset=UTF-8")
public class RankingController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    RankingService rankingService;

    /**
     * 按照客户总数进行本周排名
     * @return
     */
    @RequestMapping(value = "/rankUserCountByThisWeek",method = RequestMethod.GET)
    public MyResponse rankUserCountByThisWeek() {
        try {
            return MyResponseUtil.success(rankingService.rankUserCountByThisWeek());
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 按照客户总数进行本月排名
     * @return
     */
    @RequestMapping(value = "/rankUserCountByThisMonth",method = RequestMethod.GET)
    public MyResponse rankUserCountByThisMonth() {
        try {
            return MyResponseUtil.success(rankingService.rankUserCountByThisMonth());
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 按照客户总数进行本年排名
     * @return
     */
    @RequestMapping(value = "/rankUserCountByThisYear",method = RequestMethod.GET)
    public MyResponse rankUserCountByThisYear() {
        try {
            return MyResponseUtil.success(rankingService.rankUserCountByThisYear());
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 任意日期范围客户总数排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    @RequestMapping(value = "/rankUserCountByDateRange",method = RequestMethod.GET)
    public MyResponse rankUserCountByDateRange(@RequestParam("smallDate") String smallDate,
                                               @RequestParam("bigDate") String bigDate) {
        try {
            if (!ValidDateUtil.isValidDate(smallDate,bigDate)) {
                return MyResponseUtil.error("时间格式或日期范围不正确");
            }
            return MyResponseUtil.success(rankingService.rankUserCountByDateRange(smallDate,bigDate));
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 按照客户消费总金额进行本周排名
     * @return
     */
    @RequestMapping(value = "/rankUserPayByThisWeek",method = RequestMethod.GET)
    public MyResponse rankUserPayByThisWeek() {
        try {
            return MyResponseUtil.success(rankingService.rankUserPayByThisWeek());
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 按照客户消费总金额进行本月排名
     * @return
     */
    @RequestMapping(value = "/rankUserPayByThisMonth",method = RequestMethod.GET)
    public MyResponse rankUserPayByThisMonth() {
        try {
            return MyResponseUtil.success(rankingService.rankUserPayByThisMonth());
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 按照客户消费总金额进行本年排名
     * @return
     */
    @RequestMapping(value = "/rankUserPayByThisYear",method = RequestMethod.GET)
    public MyResponse rankUserPayByThisYear() {
        try {
            return MyResponseUtil.success(rankingService.rankUserPayByThisYear());
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }

    /**
     * 任意日期范围客户消费总金额排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    @RequestMapping(value = "/rankUserPayByDateRange",method = RequestMethod.GET)
    public MyResponse rankUserPayByDateRange(@RequestParam("smallDate") String smallDate,
                                               @RequestParam("bigDate") String bigDate) {
        try {
            if (!ValidDateUtil.isValidDate(smallDate,bigDate)) {
                return MyResponseUtil.error("时间格式或日期范围不正确");
            }
            return MyResponseUtil.success(rankingService.rankUserPayByDateRange(smallDate,bigDate));
        } catch (Exception e) {
            logger.error("排名系统异常" + e.getMessage());
            return MyResponseUtil.error(e.getMessage());
        }
    }
}
