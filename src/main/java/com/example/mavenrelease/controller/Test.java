package com.example.mavenrelease.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName :  Test
 * @Author: xwl
 * @Date: 2022/6/15 16:52
 **/
@RestController
public class Test {
    @GetMapping("/test")
    public String test(String name){
        return name;
    }
}
