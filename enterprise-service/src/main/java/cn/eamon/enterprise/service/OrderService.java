package cn.eamon.enterprise.service;

import cn.eamon.enterprise.dao.OrderDao;
import cn.eamon.enterprise.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 15:53
 */
public interface OrderService {

    /**
     * 查找所有的订单列表
     */
    List<Orders> findAllByPage(int page, int pageSize) throws Exception;

    /**
     * 根据订单id查询订单详情
     */
    Orders findById(int id) throws Exception;
}
