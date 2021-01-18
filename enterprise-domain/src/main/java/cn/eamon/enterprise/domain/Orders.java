package cn.eamon.enterprise.domain;

import cn.eamon.enterprise.domain.common.Constant;
import cn.eamon.enterprise.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/15 14:51
 */
@Data
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateUtils.date2String(orderTime, "yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    private String orderTimeStr;
    private int orderStatus;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    private String orderStatusStr;

    public String getOrderStatusStr() {
        if (orderStatus == 1) {
            orderStatusStr = Constant.STATUS_OPEN;
        } else {
            orderStatusStr = Constant.STATUS_CLOSE;
        }
        return orderStatusStr;
    }
}
