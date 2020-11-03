package com.module.postgresql;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.module.dataaccesser.postgresql")
public class PGConfiguration {

}
