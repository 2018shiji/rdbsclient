package com.module.dataAccesser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RDBSClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RDBSClientApplication.class, args);
    }

}
