package com.shijiu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Worlda3t都是通过防腐剂定  ";
    }
}
