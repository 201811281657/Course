package com.course.server.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import com.course.server.util.UuidUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.PropertiesPersister;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Field;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    /**
     * 定义一个切点
     */
    @Pointcut("execution(public * com.course.*.controller..*Controller.*(..))")
    public void controllerPointcut(){}
    @Before("controllerPointcut()")
    public void dobefore(JoinPoint joinPoint) throws Throwable{
        //日志编号
        MDC.put("UUID", UuidUtil.getShortUuid());
        //开始打印目标请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        //打印业务操作
        String nameCn = "";
        if(name.contains("list")||name.contains("query")){
            nameCn = "查询";
        }else if (name.contains("save")){
            nameCn = "保存";
        }else if (name.contains("delete")){
            nameCn = "删除";
        }else{
            nameCn = "操作";
        }
        //使用反射获取业务名称
        Class clazz = signature.getDeclaringType();
        Field field;
        String businessName = "";
        try {
            field = clazz.getField("BUSINESS_NAME");
            if(!StringUtils.isEmpty(field)){
                businessName = (String) field.get(clazz);
            }
        } catch (NoSuchFieldException e) {
            log.warn("未获取到业务名称");
        } catch (SecurityException e) {
            log.warn("获取业务名称失败");
        }
        //打印请求信息
        log.info("-------------------[{}]{}开始-------------------",businessName,nameCn);
        log.info("请求地址:{} {}",request.getRequestURL().toString());
        log.info("类名方法:{} {}",signature.getDeclaringTypeName(),name);
        log.info("远程地址:{} {}",request.getRemoteAddr());
        //打印传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for(int i = 0;i<args.length;i++){
            if(args[i] instanceof ServletRequest ||args[i]instanceof ServletResponse||args[i] instanceof MultipartFile){
                continue;
            }
            arguments[i] = args[i];
        }
        //排除字段,敏感字段或者太长的字段不显示
        String[] excludeProperties = {};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);
        log.info("请求参数:{}", JSONObject.toJSONString(arguments,excludefilter));//为空的不会打印,但是像图片等字段会打印
    }
    @Around("controllerPointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        // 排除字段，敏感字段或太长的字段不显示
        String[] excludeProperties = {"password", "shard"};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);
        log.info("返回结果: {}", JSONObject.toJSONString(result, excludefilter));
        log.info("------------- 结束 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
        return result;
    }
}
