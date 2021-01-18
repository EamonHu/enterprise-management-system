package cn.eamon.enterprise.service;

import cn.eamon.enterprise.domain.Product;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/13 17:15
 */
public interface ProductService {

    /**
     * 查询所有产品product
     */
    List<Product> findAll() throws Exception;

    /**
     * 保存一个产品
     */
    void save(Product product);
}
