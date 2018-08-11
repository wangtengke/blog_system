package com.blog.wtk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@MapperScan("com.blog.wtk.Mapper")
public class WtkApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtkApplication.class, args);
    }
}
