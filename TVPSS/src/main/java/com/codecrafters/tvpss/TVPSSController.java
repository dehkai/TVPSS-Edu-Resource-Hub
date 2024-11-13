package com.codecrafters.tvpss;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TVPSSController {

    @RequestMapping
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
}
