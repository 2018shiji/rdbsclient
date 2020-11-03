package com.module.postgresql;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostgreSQLApplicationTests {

    RestClientUtil util = new RestClientUtil();

    @Test
    void getArticleByIdDemo() {
        util.getArticleByIdDemo();
    }

    @Test
    void addArticleDemo(){
        util.addArticleDemo();
    }

    @Test
    void updateArticleDemo(){ util.updateArticleDemo(); }

    @Test
    void deleteArticleDemo(){
        util.deleteArticleDemo();
    }


    @Test
    void getAllArticleDemo(){
        util.getAllArticlesDemo();
    }

    Logger logger = LoggerFactory.getLogger("KAFKA");
    Logger loggerTest = LoggerFactory.getLogger(PostgreSQLApplicationTests.class);

    @Test
    void testKafkaLog(){
        logger.info("this is kafka String----------------------------------------------------------------------------");
        loggerTest.info("this is test String");
        System.out.println("something happen, this is System.out.println()");
    }

}
