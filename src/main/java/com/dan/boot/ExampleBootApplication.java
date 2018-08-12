package com.dan.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 写一个主函数构建Spring容器,SpringBoot一定要有一个出口
 * 可以关闭特定的自动装配
 */
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//public class ExampleBootApplication {
//    public static void main(String[] args) {
////        SpringApplication.run(ExampleBootApplication.class,args);
//
////        关闭Banner  第一种方法
//        SpringApplication application=new SpringApplication(ExampleBootApplication.class);
////        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);
////        第二种方法
//        SpringApplication application1= (SpringApplication) new SpringApplicationBuilder(ExampleBootApplication.class)
//                .bannerMode(Banner.Mode.OFF).run(args);
//    }
//}


@SpringBootApplication
//        (exclude = DataSourceAutoConfiguration.class)
//@PropertySource(value = "classpath:application.properties")
public class ExampleBootApplication{
    public static void main(String[] args) {
         SpringApplication.run(ExampleBootApplication.class,args);
    }
}
