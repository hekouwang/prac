package com.microfian.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.microfian.prac.mapper")
public class PracApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracApplication.class, args);
    }

}
