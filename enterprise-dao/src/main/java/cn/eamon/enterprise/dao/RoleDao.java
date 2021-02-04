package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 17:50
 */
@Component
public interface RoleDao {

    /**
     * 根据用户ID查询对应的角色
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class,
                    many = @Many(select = "cn.eamon.enterprise.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRoleByUserId(Integer userId) throws Exception;


    /**
     * 查看所有角色信息
     */
    @Select("select * from role")
    List<Role> findAll();

    /**
     * 新增角色
     */
    @Insert("insert into role(roleName, roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    /**
     * 查找其他角色信息
     */
    @Select("select * from role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findOtherRole(Integer id);

    /**
     * 给角色添加权限
     */
    @Insert("insert into role_permission (roleId,permissionId) value (#{roleId}, #{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") int permissionId);

    /**
     * 查询角色详情
     */
    @Select("select id, roleName, roleDesc from role where id = #{roleId}")
    Role findById(Integer roleId);
}
