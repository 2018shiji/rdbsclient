package com.module.dataAccesser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataAccesserApplicationTests {

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
    void updateArticleDemo(){
        util.updateArticleDemo();
    }

    @Test
    void deleteArticleDemo(){
        util.deleteArticleDemo();
    }

    @Test
    void getAllArticleDemo(){
        util.getAllArticlesDemo();
    }

}
