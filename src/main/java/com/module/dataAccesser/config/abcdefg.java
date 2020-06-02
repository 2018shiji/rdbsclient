package com.module.dataAccesser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("abcdefg")
public class abcdefg {
    ThreadLocal local = new ThreadLocal();
    InheritableThreadLocal inheritableLocal = new InheritableThreadLocal();

    @Bean
    public SonOfAbc getSonOfAbc(){
        return new SonOfAbc();
    }

}
