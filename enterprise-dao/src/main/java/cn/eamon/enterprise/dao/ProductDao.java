package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/13 17:06
 */
@Component
public interface ProductDao {

    /**
     * 查询所有产品
     */
    @Select("select id, productNum, productName, cityName, departureTime, productPrice, " +
            "productDesc, productStatus from product")
    List<Product> findAll() throws Exception;
}
