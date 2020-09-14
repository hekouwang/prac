package com.microFian.prac.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.microFian.prac.security.config"})
public class PracWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracWebApplication.class, args);
    }

}
