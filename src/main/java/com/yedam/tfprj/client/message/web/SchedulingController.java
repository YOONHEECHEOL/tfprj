package com.yedam.tfprj.client.message.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulingController {
    public static void main(String[] args){
        SpringApplication.run(SchedulingController.class, args);
    }
}
