package cn.eamon.enterprise.domain;

import cn.eamon.enterprise.utils.DateUtils;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/2/2 15:40
 */
@Data
@Accessors(chain = true)
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getVisitTimeStr() {
        return DateUtils.date2String(visitTime,"yyyy-MM-dd HH:mm:ss");
    }
}
