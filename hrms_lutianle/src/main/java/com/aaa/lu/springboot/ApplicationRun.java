package com.aaa.lu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ltl
 * @Date 2020/6/19  8:58
 * @Description
 **/
@SpringBootApplication
@MapperScan("com.aaa.lu.springboot.mapper")
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
