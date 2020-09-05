package com.example.springtest.zhoucangyu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopTestController {

    // 获取日志模块
    private static final Logger logger = LoggerFactory.getLogger(AopTestController.class);

    @GetMapping("test1")
    public String helloWorld(@RequestParam String name) throws Exception {
        logger.info("/aop/test1的controller正在运行中");
//        throw new Exception("我是异常");
        return "hello," + name;
    }


}
