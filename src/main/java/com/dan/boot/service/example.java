package com.dan.boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@PropertySource(value = "classpath:config.properties")
//@ImportResource(locations = "classpath:application-bean.xml")  利用这个注解可以加载第三方xml
public class example {
    @Value(value = "${my.age}")
    private int age;
    @Value(value = "${my.id}")
    private String id;
    @Value(value = "${my.name}")
    private String name;

    @RequestMapping(value = "/example")
    @ResponseBody
    public String fun(){
        return age+id+name;
    }
}
