package com.xing.springbootfreemarker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.xing"})
@MapperScan(basePackages = {"com.xing"})
public class SpringBootFreemarkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFreemarkerApplication.class, args);
    }

}
