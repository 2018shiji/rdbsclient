package com.module.mysql;

import com.module.mysql.datasswitch.DDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * https://www.cnblogs.com/codecat/p/13406031.html
 * MySQL实例数据库：
 * https://github.com/datacharmer/test_db
 * https://dev.mysql.com/doc/index-other.html
 * https://blog.csdn.net/horses/article/details/106795844
 */
@Import({DDataSourceRegister.class})
@SpringBootApplication
public class MysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }


}
