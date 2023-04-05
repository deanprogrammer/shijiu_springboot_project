package com.shijiu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.shijiu")
public class ShiJiuApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShiJiuApplication.class, args);
    }
}
