package com.eve.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author han aijun
 * @Date 2021/4/28 13:59
 * @Version 1.0
 */
@Aspect
@Component
@Profile({"dev","test"}) //一般生产环境不允许日志打印参数
@Slf4j
public class LogPrintAspect {


    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.eve.aspect.SysLog)")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = (HttpSession) attributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        log.info("classMethod:======>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("method:======>" + request.getMethod());
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object o = args[i];
            if(o instanceof ServletRequest || (o instanceof ServletResponse) || o instanceof MultipartFile){
                args[i] = o.toString();
            }
        }

        String str = JSONObject.toJSONString(args);
        str = str.length() > 2000 ? str.substring(2000) : str;
        log.info("params:======>" + str);

        if(session != null){
            log.info("session id :======>" + session.getId());
        }
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Exception e) {
            log.error("exception message :======>" + e.getMessage());
            throw e;
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        String retString = JSONObject.toJSONString(ret);
        retString = retString.length() > 2000 ? retString.substring(2000) : retString;
        log.info("ret:======>" + retString);
        log.info("useTime:======>" + (System.currentTimeMillis() - startTime.get()) + "");
    }


}
