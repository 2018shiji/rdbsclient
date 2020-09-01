package com.module.dataaccesser.postgresql;

import com.module.dataaccesser.core.trace.MdcServletFilter;
import com.module.dataaccesser.core.trace.MdcTraceIdInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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


}
