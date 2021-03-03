package com.module.mysql.ppDai.migrate.persistQueue;

import com.module.mysql.ppDai.entity.LoanPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


@Component
public class PersistentLPQueue {
    int capacity = 5000;
    Logger logger = LoggerFactory.getLogger(PersistentLPQueue.class);
    private BlockingQueue<LoanPlan> loanPlans = new ArrayBlockingQueue<>(capacity);

    public void offerLoanPlanInTime(LoanPlan loanPlan){
        try{
            loanPlans.offer(loanPlan, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for loanPlan: " + loanPlan + " with exception: " + e.getMessage());
        }
    }

    public BlockingQueue<LoanPlan> getLoanPlans(){
        return loanPlans;
    }
}
