package com.xing.springbootfileupload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.xing"})
@MapperScan(basePackages = {"com.xing"})
public class SpringBootFileuploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFileuploadApplication.class, args);
    }

}
