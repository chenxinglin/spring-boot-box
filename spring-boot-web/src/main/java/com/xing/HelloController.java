package com.xing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    @ResponseBody
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
