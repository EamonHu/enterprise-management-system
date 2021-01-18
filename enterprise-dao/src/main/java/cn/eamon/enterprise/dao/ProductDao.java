package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 保存一个产品信息
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values" +
            "(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据id查询订单信息
     */
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
}
