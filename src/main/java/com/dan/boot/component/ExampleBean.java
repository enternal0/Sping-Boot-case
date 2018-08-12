package com.dan.boot.component;

import org.springframework.stereotype.Component;

@Component
public class ExampleBean {
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
