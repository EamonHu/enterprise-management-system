package cn.eamon.enterprise.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 17:14
 */
@Data
public class Permission {
    private Integer id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
