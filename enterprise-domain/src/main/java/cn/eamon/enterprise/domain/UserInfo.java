package cn.eamon.enterprise.domain;

import cn.eamon.enterprise.domain.common.Constant;
import lombok.Data;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 17:13
 */
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if (status == 0) {
            statusStr = Constant.STATUS_CLOSE;
        } else {
            statusStr = Constant.STATUS_OPEN;
        }
        return statusStr;
    }
}
