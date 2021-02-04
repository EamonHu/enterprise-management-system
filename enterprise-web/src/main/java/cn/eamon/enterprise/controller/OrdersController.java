package cn.eamon.enterprise.controller;

import cn.eamon.enterprise.domain.Orders;
import cn.eamon.enterprise.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 15:18
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired(required = false)
    private OrderService ordersService;

    /**
     * 查找所有订单
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize
    ) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAllByPage(page, pageSize);
        // pageInfo是一个分页的bean
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    /**
     * 根据订单ID查看订单详情
     * @param id 订单id
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.setViewName("orders-show");
        mv.addObject("orders", orders);
        return mv;
    }
}
