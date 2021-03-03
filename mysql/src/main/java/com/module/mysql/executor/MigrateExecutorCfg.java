package com.module.mysql.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class MigrateExecutorCfg {
    private int corePoolSize = 10;
    private int maxPoolSize = 32;
    private int queueCapacity = 10;

    @Bean
    public Executor migrateExecutor() {
        ThreadPoolTaskExecutor executor = new VisibleTPTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("Migrate Executor-");
        executor.initialize();
        return executor;

    }
}
