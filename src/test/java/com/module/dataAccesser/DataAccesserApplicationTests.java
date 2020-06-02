package com.module.dataAccesser;

import com.module.dataAccesser.config.abcdefg;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataAccesserApplicationTests {

    @Autowired
    com.module.dataAccesser.config.abcdefg abcdefg;

    @Test
    void contextLoads() {

    }

}
