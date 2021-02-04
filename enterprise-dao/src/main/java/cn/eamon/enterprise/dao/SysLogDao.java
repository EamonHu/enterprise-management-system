package cn.eamon.enterprise.dao;

import cn.eamon.enterprise.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/2/4 14:40
 */
@Repository
public interface SysLogDao {

    /**
     * 保存系统操作权限信息
     */
    @Insert("insert into syslog(visitTime, username, ip, url, executionTime, method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    /**
     * 查询角色的所有信息
     */
    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;
}
