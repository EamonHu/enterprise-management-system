package cn.eamon.enterprise.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 17:13
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;
}
