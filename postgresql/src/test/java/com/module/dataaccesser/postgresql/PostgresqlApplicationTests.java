package com.module.dataaccesser.postgresql;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostgresqlApplicationTests {

    RestClientUtil util = new RestClientUtil();
    PlateRestClientUtil plateUtil = new PlateRestClientUtil();
    DockRestClientUtil dockUtil = new DockRestClientUtil();

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

    @Test
    void getPlateById(){
        plateUtil.getPlateByPlateId();
    }

    @Test
    void getDockById(){
        dockUtil.getDockByDockId();
    }

}
