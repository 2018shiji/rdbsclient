package com.module.mysql.ppDai.migrate;

import com.module.mysql.ppDai.entity.LoanPlan;
import com.module.mysql.ppDai.entity.RepayStatus;
import com.module.mysql.ppDai.migrate.persistQueue.PersistentLPQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class LoanPlanLineParser {
    @Autowired
    private PersistentLPQueue loanPlanQueue;
    private List<String> tableHeader = new ArrayList<>();

    public void parseLoanPlanHeader(String[] header){

    }

    public void parseLoanPlanContent(String[] line){
        transToPojoList(line);
    }

    private void transToPojoList(String[] line){
        if(line == null || line.length == 0)
            return;

        int listingId = Integer.parseInt(line[0]);
        short periods = Short.parseShort(line[1]);
        RepayStatus repayStatus = RepayStatus.UNKNOWN;
        if("1".equals(line[2])) {
            repayStatus = RepayStatus.DONE;
        } else if ("2".equals(line[2])) {
            repayStatus = RepayStatus.UNDONE;
        }

        float principalRepayable = Float.valueOf(line[3]);
        float interestRepayable = Float.valueOf(line[4]);
        float remainPrincipal = Float.valueOf(line[5]);
        float remainInterest = Float.valueOf(line[6]);

        Date expiryDate = new Date();
        Date repayDate = new Date();
        Date recordDate = new Date();
        try {
            expiryDate = new SimpleDateFormat("yyyy/MM/dd").parse(line[7]);
            repayDate = new SimpleDateFormat("yyyy/MM/dd").parse(line[8]);
            recordDate = new SimpleDateFormat("yyyy/MM/dd").parse(line[9]);
        } catch (Exception e){e.printStackTrace();}

        LoanPlan.LoanPlanDetail loanPlanDetail = new LoanPlan.LoanPlanDetail(listingId, periods, repayStatus);
        LoanPlan.PlanPrincipalInterest principalInterest = new LoanPlan.PlanPrincipalInterest(
                principalRepayable, interestRepayable, remainPrincipal, remainInterest);
        LoanPlan.PlanDateDetail planDateDetail = new LoanPlan.PlanDateDetail(expiryDate, repayDate, recordDate);

        LoanPlan loanPlan = new LoanPlan();
        loanPlan.setLoanPlanDetail(loanPlanDetail);
        loanPlan.setPlanPrincipalInterest(principalInterest);
        loanPlan.setPlanDateDetail(planDateDetail);

        loanPlanQueue.offerLoanPlanInTime(loanPlan);
    }
}
