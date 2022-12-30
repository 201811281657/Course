package com.course.server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.course.server.mapper")
@ComponentScan("com.course.server.service")
//@ComponentScan("com.course")
public class MallGatatotyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallGatatotyApplication.class, args);

    }
}
