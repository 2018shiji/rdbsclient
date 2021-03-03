package com.module.mysql;

import com.module.mysql.movie.migrate.OralMovieCsvReader;
import com.module.mysql.task.PPDaiMigrateTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Future;

@SpringBootTest
public class MySqlApplicationTests {
    @Autowired
    OralMovieCsvReader oralMovieCsvReader;

    @Test
    void testCredits(){
        oralMovieCsvReader.readCredits();
    }

    @Test
    void testMovies(){
        oralMovieCsvReader.readMovies();
    }

    @Autowired
    PPDaiMigrateTask ppDaiMigrateTask;

    @Test
    void testPPDaiSMigrateTask() throws Exception{
        Future<String> singleLoanTask = ppDaiMigrateTask.migrateSLoan();
        Future<String> singleLoanPlanTask = ppDaiMigrateTask.migrateSLoanPlan();

        while(true) {
            if(singleLoanTask.isDone() && singleLoanPlanTask.isDone()) {
                System.out.println("singleLoanTask result: " + singleLoanTask.get());
                System.out.println("singleLoanPlanTask result: " + singleLoanPlanTask.get());
                break;
            }
            Thread.sleep(1000);
        }

        System.out.println(("All tasks finished."));
    }

    @Test
    void testPPDaiBMigrateTask() throws Exception {
        Future<String> batchLoanTask = ppDaiMigrateTask.migrateBLoan();
        Future<String> batchLoanPlanTask = ppDaiMigrateTask.migrateBLoanPlan();

        while(true){
            if(batchLoanTask.isDone() && batchLoanPlanTask.isDone()){
                System.out.println("batchLoanTask result: " + batchLoanTask.get());
                System.out.println("batchLoanPlanTask result: " + batchLoanPlanTask.get());
                break;
            }
            Thread.sleep(1000);
        }

        System.out.println("All tasks finished");
    }
}
