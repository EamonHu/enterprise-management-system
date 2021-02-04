package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/28 22:20
 */
public interface PermissionDao {

    /**
     * 根据角色ID查询所有权限信息
     */
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findByRoleId(Long roleId);

    /**
     * 查找所有权限
     */
    @Select("select * from permission")
    List<Permission> findAll();

    /**
     * 新增权限
     */
    @Insert("insert into permission(permissionName,url) values(#{permissionName}, #{url})")
    void save(Permission permission);

    /**
     * 查找该角色的其他权限
     */
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(Integer roleId);
}
