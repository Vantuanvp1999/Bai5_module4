package com.example.baitap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Demo {

    @GetMapping("/index")
    public String index() {
        return "Hello World";
    }
}
