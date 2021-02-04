package cn.eamon.enterprise.controller;

import cn.eamon.enterprise.domain.SysLog;
import cn.eamon.enterprise.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/2/2 16:11
 */
@RequestMapping("/sysLog")
@Controller
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 查看所有操作日志
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs", sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
