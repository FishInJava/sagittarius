package com.hobozoo.sagittarius.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class ControllerAspect {
    /**
     * controller目录下，所有类，所有方法
     */
    @Pointcut("execution(* com.hobozoo.sagittarius.controller.*.*(..) )")
    public void controllerLogPointCut(){

    }

    @Around("controllerLogPointCut()")
    public Object around(ProceedingJoinPoint pjp){
        String methodName = pjp.getSignature().getName();
        log.info("{}--request：{} ",methodName, JSONObject.toJSON(pjp.getArgs()));
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            log.error("proceed exception，{}",throwable.toString());
        }
        log.info("{}--response：{} ",methodName, JSONObject.toJSON(proceed));
        return null;
    }

}
