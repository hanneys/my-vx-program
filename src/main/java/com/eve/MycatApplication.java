package com.eve;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.eve.mapper"})
@EnableScheduling
public class MycatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycatApplication.class, args);
    }


}
