package com.module.dataaccesser.postgresql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.module.dataAccesser.postgreSQL")
public class PGConfiguration {

}
