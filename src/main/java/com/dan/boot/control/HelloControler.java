package com.dan.boot.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControler {

    @RequestMapping
    @ResponseBody
    public String index(){
        return "Hello World Hello Spring Boot";
    }
}
