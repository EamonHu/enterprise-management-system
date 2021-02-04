package cn.eamon.enterprise.service.impl;

import cn.eamon.enterprise.dao.OrderDao;
import cn.eamon.enterprise.domain.Orders;
import cn.eamon.enterprise.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 15:56
 */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> findAllByPage(int page, int pageSize) throws Exception {
        // pageNum是页码值，pageSize是每页显示条数
        // 必须写在执行方法之前！！！
        PageHelper.startPage(page, pageSize);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(int id) throws Exception {
        return orderDao.findById(id);
    }
}
