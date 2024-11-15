package com.codecrafters.tvpss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TVPSSController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    // Example additional mapping
    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
}
