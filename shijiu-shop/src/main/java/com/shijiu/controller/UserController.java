package com.shijiu.controller;

import com.shijiu.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController extends BaseController {

    @GetMapping("/reg.do")
    public String showReg(){
        return "register";
    }

    public static void main(String[] args) {
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);
    }
}
