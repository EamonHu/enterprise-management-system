package cn.eamon.enterprise.service;

import cn.eamon.enterprise.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/29 14:40
 */
public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findOtherPermission(Integer roleId);
}
