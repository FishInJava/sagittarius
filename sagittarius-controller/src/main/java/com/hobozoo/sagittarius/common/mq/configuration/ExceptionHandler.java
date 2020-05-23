package com.hobozoo.sagittarius.common.mq.configuration;

import com.hobozoo.sagittarius.common.mq.entity.demo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler
    public Object handlerAllException(HttpServletResponse httpServletResponse,Exception exception){
        log.error("ex:{}",exception.toString());
        return new Result<Object>();
    }

}
