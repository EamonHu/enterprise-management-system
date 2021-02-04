package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 17:27
 */
@Component
public interface UserDao {

    /**
     * 查询用户信息
     */
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id=true, property = "id",column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "password", property = "password"),
            @Result(column = "id", property = "roles", javaType = List.class,
                    many=@Many(select="cn.eamon.enterprise.dao.RoleDao.findRoleByUserId")) })
    UserInfo findById(int id) throws Exception;

    /**
     * 通过用户名查找用户信息
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class,
                    many = @Many(select = "cn.eamon.enterprise.dao.RoleDao.findRoleByUserId"))})
    UserInfo findByUsername(String username);

    /**
     * 查看所有用户
     */
    @Select("select id, email, username, PASSWORD, phoneNum, STATUS from users ")
    List<UserInfo> findAll();

    /**
     * 添加用户
     */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo user);

    /**
     * 给用户添加角色
     */
    @Insert("insert into users_role(userId, roleId) values(#{userId}, #{roleId})")
    void addRoleToUser(@Param("userId")int userId, @Param("roleId")int roleId);
}

