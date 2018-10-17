package com.sw.urs.dao;

import com.sw.urs.model.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginTicketDao {
    String TABLE_NAME = " login_ticket ";
    String INSERT_FIELDS = " admin_id,ticket,expired,status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    /**
     * 添加登录ticket
     * @param loginTicket
     * @return
     */
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELDS,") values(#{adminId},#{ticket},#{expired},#{status})"})
    int addTicket(LoginTicket loginTicket);

    /**
     * 根据ticket查询LoginTicket
     * @param ticket
     * @return
     */
    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME," where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);

    /**
     * 修改ticket状态
     * @param ticket
     * @param status
     * @return
     */
    @Update({"update ",TABLE_NAME," set status=#{status} where ticket=#{ticket}"})
    int updateStatus(@Param("ticket") String ticket,@Param("status") int status);
}
