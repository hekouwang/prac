package com.microfian.prac.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.microfian.prac.web.mapper")
public class PracWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracWebApplication.class, args);
    }

}
