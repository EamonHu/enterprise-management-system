package cn.eamon.enterprise.controller;

import cn.eamon.enterprise.domain.SysLog;
import cn.eamon.enterprise.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2021/2/2 15:44
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private SysLogService sysLogService;

    private Date startTime;
    private Class executionClass;
    private Method executionMethod;

    /**
     * 获取访问时间，访问的类，访问的方法
     */
    @Before("execution(* cn.eamon.enterprise.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        startTime = new Date();
        executionClass = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();

        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            executionMethod = executionClass.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < classArgs.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            executionMethod = executionClass.getMethod(methodName, classArgs);
        }
    }

    @After("execution(* cn.eamon.enterprise.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        if (executionClass != SysLogController.class) {
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String url;
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];
                    SysLog sysLog = new SysLog();
                    Long executionTime = System.currentTimeMillis() - startTime.getTime();
                    String ip = httpServletRequest.getRemoteAddr();

                    SecurityContext context = SecurityContextHolder.getContext();
                    String username = ((User) (context.getAuthentication().getPrincipal())).getUsername();
                    sysLog.setExecutionTime(executionTime)
                            .setUrl(url)
                            .setIp(ip)
                            .setUsername(username)
                            .setMethod("[类名]" + executionClass.getName() + "[方法名]" + executionMethod.getName())
                            .setVisitTime(startTime);
                    sysLogService.save(sysLog);
                }
            }
        }
    }
}
