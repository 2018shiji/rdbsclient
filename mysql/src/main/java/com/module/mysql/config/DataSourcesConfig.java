package com.module.mysql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages= { "com.module.mysql.ppDai.repository",
                        "com.module.mysql.movie.repository" }) //设置Repository所在位置
public class DataSourcesConfig {

}
