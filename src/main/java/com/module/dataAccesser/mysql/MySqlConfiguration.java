package com.module.dataAccesser.mysql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.module.dataAccesser.mysql.repository")
public class MySqlConfiguration {

}
