package com.baizhi.cmfz.advice;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

import java.util.Random;



@Aspect
public class MyAdvice {
    @Autowired
    private LogService ls;
    @Autowired
    private HttpSession httpSession;
    /**
    *@Author    zsj
    *@Description 指定切入点
    *@Time  2018/7/9 21:41
    */
    @Pointcut("(execution(* com.baizhi.cmfz.serviceImpl.*.add*(..)) ||execution( * com.baizhi.cmfz.serviceImpl.*.modify*(..)) ||execution( * com.baizhi.cmfz.serviceImpl.*.remove*(..))) && !execution(* com.baizhi.cmfz.serviceImpl.LogServiceImpl.*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        /*HttpSession session = (HttpSession) RequestContextHolder
                .currentRequestAttributes()
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
         */
        Log log = new Log();
        String userName=(String)httpSession.getAttribute("mn");
        System.out.println(userName);
        log.setLogUser(userName);
        //获取方法
         MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        //获取类名
        Class<?> aClass = pjp.getTarget().getClass();
        String s1 = aClass.getName().substring(aClass.getName().lastIndexOf(".")+1, aClass.getName().length());
        String logResource = s1.replace("ServiceImpl", "");
        log.setLogResource(logResource);
        //参数
        Object[] args = pjp.getArgs();
        String message = "";
        for (Object arg : args) {
            message+=arg.toString();
        }
        //添加message
        log.setLogMessage(message);
        if(method.getName().contains("add")){
            log.setLogAction("增加");
        }else if (method.getName().contains("modify")){
            log.setLogAction("修改");
        }else{
            log.setLogAction("删除");
        }
        try {
            //放行
            Object obj = pjp.proceed();

           log.setLogResult("success");

            return obj;
        } catch (Throwable throwable) {
            log.setLogResult("error");
            throwable.printStackTrace();
        }finally {
            ls.addLog(log);
        }
        return null;
    }
}
