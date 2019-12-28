package com.doing.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "com.doing" },exclude = {DataSourceAutoConfiguration.class})
public class DoingWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoingWebApplication.class, args);
    }

}
