package com.dan.boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//@ConfigurationProperties(prefix = "book",locations=)
@Controller
@RequestMapping
public class Demo1 {
    @Autowired
    private Environment environment;

    @RequestMapping(value = "/environment", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> environment() {
        Map<String, Object> map = new HashMap<>();
        map.put("app.config.host", environment.getProperty("app.config.host"));
        map.put("java.home", environment.getProperty("java.home"));
        map.put("user.dir", environment.getProperty("user.dir"));
        return map;
    }
}
