package com.module.mysql.task;

import com.module.mysql.ppDai.migrate.persistStrategy.PPDaiBatchInsert;
import com.module.mysql.ppDai.migrate.persistStrategy.PPDaiSingleInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class PPDaiMigrateTask {
    @Autowired
    PPDaiSingleInsert ppDaiSInsert;
    @Autowired
    PPDaiBatchInsert ppDaiBInsert;

    public Future<String> migrateSLoan() {
        System.out.println("single loan migrate task started...");
        long start = System.currentTimeMillis();
        ppDaiSInsert.doLCSMigrateJob();
        long end = System.currentTimeMillis();
        System.out.println("single loan migrate task finish in time: " + (end-start));
        return new AsyncResult("single loan migrate task finish");
    }

    public Future<String> migrateSLoanPlan() {
        System.out.println("single loan plan migrate task started...");
        long start = System.currentTimeMillis();
        ppDaiSInsert.doLPSMigrateJob();
        long end = System.currentTimeMillis();
        System.out.println("single loan plan migrate task finish in time: " + (end-start));
        return new AsyncResult("single loan plan migrate task finish");
    }

    public Future<String> migrateBLoan(){
        System.out.println("batch loan migrate task started...");
        long start = System.currentTimeMillis();
        ppDaiBInsert.doLCBMigrateJob();
        long end = System.currentTimeMillis();
        System.out.println("batch loan migrate task finish in time: " + (end-start));
        return new AsyncResult("batch loan migrate task finish");
    }

    public Future<String> migrateBLoanPlan(){
        System.out.println("batch loan plan migrate task started...");
        long start = System.currentTimeMillis();
        ppDaiBInsert.doLPBMigrateJob();
        long end = System.currentTimeMillis();
        System.out.println("batch loan plan migrate task finish in time: " + (end-start));
        return new AsyncResult("batch loan plan migrate task finish");
    }
}
