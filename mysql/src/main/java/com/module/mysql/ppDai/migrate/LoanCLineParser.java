package com.module.mysql.ppDai.migrate;

import com.module.mysql.ppDai.entity.Certification;
import com.module.mysql.ppDai.entity.Gender;
import com.module.mysql.ppDai.entity.Loan;
import com.module.mysql.ppDai.migrate.persistQueue.PersistentLCQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LoanCLineParser {
    @Autowired
    private PersistentLCQueue loanCQueue;
    private List<String> tableHeader = new ArrayList<>();

    public void parseLoanCHeader(String[] header){

    }

    public void parseLoanCContent(String[] line){
        transToPojoList(line);
    }

    private void transToPojoList(String[] line){
        if(line == null || line.length == 0)
            return;

        int listingId = Integer.parseInt(line[0]);
        int loanAmount = Integer.parseInt(line[1]);
        short loanPeriod = Short.parseShort(line[2]);
        int loanRate = Integer.parseInt(line[3]);
        Date loanDate = new Date();
        try {
            loanDate = new SimpleDateFormat("yyyy/MM/dd").parse(line[4]);
        } catch (Exception e){e.printStackTrace();}
        Character initialRating = line[5].charAt(0);
        String loanType = line[6];
        boolean headerLabel = "否".equals(line[7]) ? false : true;
        short borrowerAge = Short.parseShort(line[8]);
        Gender borrowerGender;
        if("男".equals(line[9]))
            borrowerGender = Gender.MALE;
        else if("女".equals(line[9]))
            borrowerGender = Gender.FEMALE;
        else
            borrowerGender = Gender.UNKNOWN;
        Certification mobileCertify = isCertifySuccess(line[10]);
        Certification huKouCertify = isCertifySuccess(line[11]);
        Certification videoCertify = isCertifySuccess(line[12]);
        Certification educationCertify = isCertifySuccess(line[13]);
        Certification creditCertify = isCertifySuccess(line[14]);
        Certification taoBaoCertify = isCertifySuccess(line[15]);

        short historyBorrowTimes = Short.parseShort(line[16]);
        int historyLoanAmount = Integer.parseInt(line[17]);
        float totalPrincipalRepay = Float.valueOf(line[18]);
        short historyGoodRepayTimes = Short.parseShort(line[19]);
        short historyBadRepayTimes = Short.parseShort(line[20]);

        Loan.LoanDetail loanDetail = new Loan.LoanDetail(listingId, loanAmount, loanPeriod,
                loanRate, loanDate, initialRating, loanType, headerLabel, totalPrincipalRepay);

        Loan.Borrower borrower = new Loan.Borrower(borrowerAge, borrowerGender);

        Loan.CertifyDetail certifyDetail = new Loan.CertifyDetail(mobileCertify, huKouCertify, videoCertify,
                educationCertify, creditCertify, taoBaoCertify);

        Loan.HistoryDetail historyDetail = new Loan.HistoryDetail(historyBorrowTimes, historyLoanAmount, historyGoodRepayTimes, historyBadRepayTimes);

        Loan loan = new Loan();
        loan.setLoanDetail(loanDetail);
        loan.setBorrower(borrower);
        loan.setCertifyDetail(certifyDetail);
        loan.setHistoryDetail(historyDetail);

        loanCQueue.offerLoanInTime(loan);
    }

    private Certification isCertifySuccess(String inputParam){
        if("成功认证".equals(inputParam))
            return Certification.SUCCESS;
        else if("未成功认证".equals(inputParam))
            return Certification.FAILURE;
        else
            return null;
    }

}
