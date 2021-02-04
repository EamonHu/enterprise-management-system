package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 15:20
 */
@Repository
public interface OrderDao {

    /**
     * 查询所有订单
     */
    @Select("select orderNum,orderTime,orderStatus,peopleCount,payType,orderDesc,productId from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(select =
                    "cn.eamon.enterprise.dao.ProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    /**
     * 根据订单ID查询订单详情
     */
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", one = @One(select =
                    "cn.eamon.enterprise.dao.ProductDao.findById")),
            @Result(column = "id", property = "travellers", many = @Many(select =
                    "cn.eamon.enterprise.dao.TravellerDao.findByOrdersId")),
            @Result(column = "memberId", property = "member", one = @One(select =
                    "cn.eamon.enterprise.dao.MemberDao.findById")),
    })
    Orders findById(int id) throws Exception;
}
