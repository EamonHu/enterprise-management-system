package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/1/18 15:10
 */
@Component
public interface MemberDao {

    /**
     * 根据ID查询会员信息
     */
    @Select("select * from member where id=#{id}")
    Member findById(Integer id) throws Exception;
}
