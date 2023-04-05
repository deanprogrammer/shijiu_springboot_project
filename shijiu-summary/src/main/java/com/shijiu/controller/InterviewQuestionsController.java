package com.shijiu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InterviewQuestionsController {

    @GetMapping("/switchQuestion")
    public int switchQuestion(){
        int num = 2;
        switch (num){
            case 1:
                ++num;
            case 2:
                ++num;
            case 3:
                ++num;
            default:
                ++num;
            break;
        }
        System.out.println(num);
        return num;
    }

    @GetMapping("/people")
    public Map people(){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            if ((6*i+5) == (7*i-8)){
                map.put("人数", i);
                map.put("布匹", 6*i+5);
                break;
            }
        }
        System.out.println(map.toString());
        return map;
    }
}
