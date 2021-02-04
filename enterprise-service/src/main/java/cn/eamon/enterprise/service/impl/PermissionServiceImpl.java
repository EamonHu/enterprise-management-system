package cn.eamon.enterprise.service.impl;

import cn.eamon.enterprise.dao.PermissionDao;
import cn.eamon.enterprise.domain.Permission;
import cn.eamon.enterprise.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/29 14:46
 */
@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermission(Integer roleId) {
        return permissionDao.findOtherPermission(roleId);
    }
}
