package cn.eamon.enterprise.controller;

import cn.eamon.enterprise.domain.Product;
import cn.eamon.enterprise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/14 15:11
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 添加产品
     */
    @RequestMapping("/save.do")
    public String save (Product product) {
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 查询全部产品
     */
    @GetMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("products", products);
        mv.setViewName("product-list1");
        return mv;
    }
}
