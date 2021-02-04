package cn.eamon.enterprise.service;

import cn.eamon.enterprise.domain.SysLog;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/2/2 15:45
 */
public interface SysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
