package com.example.demo.controller;

import com.example.demo.entity.Result;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(path = {"/helloworld"}, method = {RequestMethod.GET})
    public Result helloworld()  {
        return Result.success("hello world!");
    }


}

