package com.course.system;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.course.server.mapper")
@ComponentScan("com.course.server.service")
@ComponentScan("com.course.system.controller")
public class SystemApplication {
    private static final Logger log = LoggerFactory.getLogger(SystemApplication.class);
//    public static void main(String[] args) {
//        SpringApplication.run(EurekaApplication.class, args);
//    }

    public static void main(String[] args) {
        System.out.println("nihao");
        System.out.println("再次测试devtool");
        SpringApplication app = new SpringApplication(SystemApplication.class);
        Environment environment = app.run(args).getEnvironment();
        log.info("启动成功！！");
        log.info("System地址：\thttp://127.0.0.1:{}",environment.getProperty("server.port"));

    }
}
