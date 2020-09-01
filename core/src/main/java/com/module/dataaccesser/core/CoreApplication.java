package com.module.dataaccesser.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka + Slf4j: https://blog.csdn.net/u012031755/article/details/80806438
 * Slf4j + traceId: https://blog.csdn.net/zhibo_lv/article/details/105093808?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.add_param_isCf
 *                  https://github.com/lingqibaobei/springboot-kafka-logs/blob/master/src/main/java/com/demo/kafka/KafkaConfigUtils.java
 */
@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

}
