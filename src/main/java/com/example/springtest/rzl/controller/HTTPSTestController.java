package com.example.springtest.rzl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("https")
public class HTTPSTestController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello, world!";
    }
}
