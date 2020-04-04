package com.hobozoo.sagittarius.controller;

import com.hobozoo.sagittarius.entity.demo.Cat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Api(tags = {"Demo"})
public class DemoController {

    @ApiOperation(value = "ping", notes = "连通测试")
    @RequestMapping(value = "/ping", method = RequestMethod.POST)
    public Cat findById(Cat pingCat) {
        Cat cat = new Cat();
        if ("ping".equals(pingCat.getName())){
            cat = Cat.builder().name("pong").build();
        }
        return cat;
    }
}
