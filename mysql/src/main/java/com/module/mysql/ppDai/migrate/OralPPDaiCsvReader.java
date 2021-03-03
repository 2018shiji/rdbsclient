package com.module.mysql.ppDai.migrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OralPPDaiCsvReader {
    @Autowired
    private LoanCLineParser LCLineParser;
    @Autowired
    private LoanPlanLineParser LPLineParser;

    public void readLoanC(){

    }

    public void readLoanPlan(){

    }
}
