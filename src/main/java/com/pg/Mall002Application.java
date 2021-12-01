package com.pg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pg.mapper")
public class Mall002Application {

    public static void main(String[] args) {
        SpringApplication.run(Mall002Application.class, args);
    }

}
