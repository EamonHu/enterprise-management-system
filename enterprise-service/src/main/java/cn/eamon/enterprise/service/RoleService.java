package cn.eamon.enterprise.service;

import cn.eamon.enterprise.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/29 14:27
 */
public interface RoleService {
    
    List<Role> findAll();

    void save(Role role);

    List<Role> findOtherRole(Integer id);

    void addPermissionToRole(Integer roleId, int[] permissionIds);

    Role findById(Integer roleId);
}
