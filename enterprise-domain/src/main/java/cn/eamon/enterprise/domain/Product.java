package cn.eamon.enterprise.domain;

import cn.eamon.enterprise.domain.common.Constant;
import cn.eamon.enterprise.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: Eamon
 * @Description: 产品实体类
 * @Date: 2021/1/13 16:58
 */
@Data
public class Product {
    /**
     * 主键
     */
    private String id;
    /**
     * 编号 唯一
     */
    private String productNum;
    /**
     * 名称
     */
    private String productName;
    /**
     * 出发城市
     */
    private String cityName;

    /**
     * 出发时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    /**
     * 产品价格
     */
    private double productPrice;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 产品状态
     */
    private Integer productStatus;
    private String productStatusStr;

    public String getProductStatusStr() {
        if (productStatus == 1) {
            productStatusStr = Constant.STATUS_OPEN;
        } else {
            productStatusStr = Constant.STATUS_CLOSE;
        }
        return productStatusStr;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.date2String(departureTime,"yyyy--MM-dd");
        }
        return departureTimeStr;
    }
}
