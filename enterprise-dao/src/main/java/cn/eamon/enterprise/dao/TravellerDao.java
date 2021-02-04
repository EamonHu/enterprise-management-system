package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 15:06
 */
@Component
public interface TravellerDao {

    /**
     *  根据订单ID查询相关游客信息列表
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(Integer ordersId) throws Exception;
}
