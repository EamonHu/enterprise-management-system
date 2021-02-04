package cn.eamon.enterprise.service.impl;

import cn.eamon.enterprise.dao.RoleDao;
import cn.eamon.enterprise.domain.Role;
import cn.eamon.enterprise.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/29 14:30
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRole(Integer id) {
        return roleDao.findOtherRole(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, int[] permissionIds) {
        for (int permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }

    @Override
    public Role findById(Integer roleId) {
        return roleDao.findById(roleId);
    }

}
