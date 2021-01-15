package cn.eamon.enterprise.service.impl;

import cn.eamon.enterprise.dao.ProductDao;
import cn.eamon.enterprise.domain.Product;
import cn.eamon.enterprise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/13 17:17
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}
