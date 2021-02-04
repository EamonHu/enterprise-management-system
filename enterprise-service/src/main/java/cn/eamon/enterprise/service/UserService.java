package cn.eamon.enterprise.service;

import cn.eamon.enterprise.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 17:24
 */
public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo user);

    UserInfo findById(Integer id) throws Exception;

    void addRoleToUser(Integer userId, int[] ids);
}
