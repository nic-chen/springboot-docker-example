package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.service.ApisixAdminClient;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.controller")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public static void init(){
        ApisixAdminClient.reg();
        System.out.println("init.");
    }

}

