package com.shijiu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HwController {

    @GetMapping("/helloS")
    public String hello(){
        return "Hello World Spring";
    }
}
