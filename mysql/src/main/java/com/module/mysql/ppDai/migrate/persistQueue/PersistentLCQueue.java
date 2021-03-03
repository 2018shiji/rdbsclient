package com.module.mysql.ppDai.migrate.persistQueue;

import com.module.mysql.ppDai.entity.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Component
public class PersistentLCQueue {
    int capacity = 5000;
    Logger logger = LoggerFactory.getLogger(PersistentLCQueue.class);
    private BlockingQueue<Loan> loans = new ArrayBlockingQueue<>(capacity);

    public void offerLoanInTime(Loan loan){
        try{
            loans.offer(loan, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for loan: " + loan + " with exception: " + e.getMessage());
        }
    }

    public BlockingQueue<Loan> getLoans(){
        return loans;
    }
}
