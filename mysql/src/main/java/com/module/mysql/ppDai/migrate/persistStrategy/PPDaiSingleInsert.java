package com.module.mysql.ppDai.migrate.persistStrategy;

import com.module.mysql.ppDai.entity.Loan;
import com.module.mysql.ppDai.entity.LoanPlan;
import com.module.mysql.ppDai.migrate.persistQueue.PersistentLCQueue;
import com.module.mysql.ppDai.migrate.persistQueue.PersistentLPQueue;
import com.module.mysql.ppDai.repository.ILoanPlanRepository;
import com.module.mysql.ppDai.repository.ILoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;

@Component
public class PPDaiSingleInsert {
    @Autowired
    private ILoanRepository loanRepo;
    @Autowired
    private ILoanPlanRepository loanPlanRepo;
    @Autowired
    private PersistentLCQueue lcQueue;
    @Autowired
    private PersistentLPQueue lpQueue;

    public void doLCSMigrateJob(){
        BlockingQueue<Loan> loans = lcQueue.getLoans();
        try {
            while(true) {
                Loan loan = loans.take();
                loanRepo.save(loan);
            }
        } catch (Exception e){e.printStackTrace();}
    }

    public void doLPSMigrateJob(){
        BlockingQueue<LoanPlan> loanPlans = lpQueue.getLoanPlans();
        try{
            while(true){
                LoanPlan loanPlan = loanPlans.take();
                loanPlanRepo.save(loanPlan);
            }
        } catch (Exception e){e.printStackTrace();}
    }

}
