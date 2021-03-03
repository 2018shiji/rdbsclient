package com.module.mysql.ppDai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOAN")
@NoArgsConstructor
public class Loan {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "LISTING_ID")
    private int listingId;

    @Column(name = "LOAN_AMOUNT")
    private int loanAmount;

    @Column(name = "LOAN_PERIOD")
    private short loanPeriod;

    @Column(name = "LOAN_RATE")
    private int loanRate;

    @Column(name = "LOAN_DATE")
    private Date loanDate;

    @Column(name = "INITIAL_RATING")
    private Character initialRating;

    @Column(name = "LOAN_TYPE")
    private String loanType;

    @Column(name = "HEADER_LABEL")
    private boolean headerLabel;            //首标

    @Column(name = "BORROWER_AGE")
    private short borrowerAge;

    @Column(name = "BORROWER_GENDER")
    private Gender borrowerGender;

    @Column(name = "MOBILE_CERTIFY")
    private Certification mobileCertify;

    @Column(name = "HUKOU_CERTIFY")
    private Certification huKouCertify;

    @Column(name = "VIDEO_CERTIFY")
    private Certification videoCertify;

    @Column(name = "EDUCATION_CERTIFY")
    private Certification educationCertify;

    @Column(name = "CREDIT_CERTIFY")
    private Certification creditCertify;

    @Column(name = "TAOBAO_CERTIFY")
    private Certification taoBaoCertify;

    @Column(name = "HISTORY_BORROW_TIMES")
    private short historyBorrowTimes;         //历史成功借贷次数

    @Column(name = "HISTORY_BORROW_AMOUNT")
    private int historyBorrowAmount;          //历史成功借贷金额

    @Column(name = "PRINCIPAL_REPAYMENT")
    private float principalRepayment;         //总代还本金

    @Column(name = "HISTORY_GOOD_REPAY_TIMES")
    private short historyGoodRepayTimes;        //历史正常还款期数

    @Column(name = "HISTORY_BAD_REPAY_TIMES")
    private short historyBadRepayTimes;         //历史逾期还款期数

    public void setLoanDetail(LoanDetail loanDetail){
        this.listingId = loanDetail.listingId;
        this.loanAmount = loanDetail.loanAmount;
        this.loanPeriod = loanDetail.loanPeriod;
        this.loanRate = loanDetail.loanRate;
        this.loanDate = loanDetail.loanDate;
        this.initialRating = loanDetail.initialRating;
        this.loanType = loanDetail.loanType;
        this.headerLabel = loanDetail.headerLabel;
        this.principalRepayment = loanDetail.principalRepayment;
    }

    public void setBorrower(Borrower borrower){
        this.borrowerAge = borrower.borrowerAge;
        this.borrowerGender = borrower.borrowerGender;
    }

    public void setCertifyDetail(CertifyDetail certifyDetail){
        this.mobileCertify = certifyDetail.mobileCertify;
        this.huKouCertify = certifyDetail.huKouCertify;
        this.videoCertify = certifyDetail.videoCertify;
        this.educationCertify = certifyDetail.educationCertify;
        this.creditCertify = certifyDetail.creditCertify;
        this.taoBaoCertify = certifyDetail.taoBaoCertify;
    }

    public void setHistoryDetail(HistoryDetail historyDetail){
        this.historyBorrowTimes = historyDetail.historyBorrowTimes;
        this.historyBorrowAmount = historyDetail.historyBorrowAmount;
        this.historyGoodRepayTimes = historyDetail.historyGoodRepayTimes;
        this.historyBadRepayTimes = historyDetail.historyBadRepayTimes;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoanDetail{
        private int listingId;
        private int loanAmount;
        private short loanPeriod;
        private int loanRate;
        private Date loanDate;
        private Character initialRating;
        private String loanType;
        private boolean headerLabel;
        private float principalRepayment;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Borrower {
        private short borrowerAge;
        private Gender borrowerGender;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CertifyDetail {
        private Certification mobileCertify;
        private Certification huKouCertify;
        private Certification videoCertify;
        private Certification educationCertify;
        private Certification creditCertify;
        private Certification taoBaoCertify;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HistoryDetail {
        private short historyBorrowTimes;
        private int historyBorrowAmount;
        private short historyGoodRepayTimes;
        private short historyBadRepayTimes;
    }
}
