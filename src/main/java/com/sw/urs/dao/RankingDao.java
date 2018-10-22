package com.sw.urs.dao;

import com.sw.urs.model.Ranking;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RankingDao {
    // 客户表名
    String USER_TABLE = " user ";
    // 销售表名
    String ADMIN_TABLE = " admin ";
    // 客户总数排名字段
    String USER_COUNT_FIELDS = " count(user.id) as user_count,admin.nick_name ";
    // 客户消费总金额排名字段
    String USER_PAY_FIELDS = " sum(user.pay_money) as total_money,admin.nick_name ";
    // 连表条件
    String ON = " on user.admin_id=admin.id ";
    // 本周
    String THIS_WEEK = " WHERE MONTH(`user`.add_time)=MONTH(CURDATE()) AND WEEK(`user`.add_time) = WEEK(CURDATE()) ";
    // 本月
    String THIS_MONTH = " WHERE MONTH(`user`.add_time)=MONTH(CURDATE()) ";
    // 本年
    String THIS_YEAR = " WHERE YEAR(`user`.add_time)=YEAR(CURDATE()) ";
    // 任意日期范围内
    String DATE_RANGE = " WHERE DATE_FORMAT(`user`.add_time,'%Y-%m-%d')>=#{smallDate} and DATE_FORMAT(`user`.add_time,'%Y-%m-%d')<=#{bigDate} ";
    // 分组条件
    String GROUP_BY = " group by user.admin_id ";
    // 客户总数排名排序条件
    String USER_COUNT_ORDER_BY = " order by count(user.id) desc ";
    // 客户消费总金额排名排序条件
    String USER_PAY_ORDER_BY = " order by sum(user.pay_money) desc ";

    /**
     * 本周客户总数排名
     * @return
     */
    @Select({" select ",USER_COUNT_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,THIS_WEEK,GROUP_BY,USER_COUNT_ORDER_BY})
    @Results({
            @Result(column = "user_count",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserCountByThisWeek();

    /**
     * 本月客户总数排名
     * @return
     */
    @Select({" select ",USER_COUNT_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,THIS_MONTH,GROUP_BY,USER_COUNT_ORDER_BY})
    @Results({
            @Result(column = "user_count",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserCountByThisMonth();

    /**
     * 本年客户总数排名
     * @return
     */
    @Select({" select ",USER_COUNT_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,THIS_YEAR,GROUP_BY,USER_COUNT_ORDER_BY})
    @Results({
            @Result(column = "user_count",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserCountByThisYear();

    /**
     * 任意日期范围客户总数排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    @Select({" select ",USER_COUNT_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,DATE_RANGE,GROUP_BY,USER_COUNT_ORDER_BY})
    @Results({
            @Result(column = "user_count",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserCountByDateRange(@Param("smallDate") String smallDate,@Param("bigDate") String bigDate);

    /**
     * 本周客户消费总金额排名
     * @return
     */
    @Select({" select ",USER_PAY_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,THIS_WEEK,GROUP_BY,USER_PAY_ORDER_BY})
    @Results({
            @Result(column = "total_money",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserPayByThisWeek();

    /**
     * 本月客户消费总金额排名
     * @return
     */
    @Select({" select ",USER_PAY_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,THIS_MONTH,GROUP_BY,USER_PAY_ORDER_BY})
    @Results({
            @Result(column = "total_money",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserPayByThisMonth();

    /**
     * 本年客户消费总金额排名
     * @return
     */
    @Select({" select ",USER_PAY_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,THIS_YEAR,GROUP_BY,USER_PAY_ORDER_BY})
    @Results({
            @Result(column = "total_money",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserPayByThisYear();


    /**
     * 任意日期范围客户消费总金额排名
     * @param smallDate 较小的日期 格式 Y-m-d
     * @param bigDate 较大的日期 格式 Y-m-d
     * @return
     */
    @Select({" select ",USER_PAY_FIELDS," from ",USER_TABLE," inner join ",ADMIN_TABLE,ON,DATE_RANGE,GROUP_BY,USER_PAY_ORDER_BY})
    @Results({
            @Result(column = "total_money",property = "condition"),
            @Result(column = "nick_name",property = "adminNickName")
    })
    List<Ranking> rankUserPayByDateRange(@Param("smallDate") String smallDate, @Param("bigDate") String bigDate);
}
