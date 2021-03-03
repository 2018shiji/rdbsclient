package com.module.mysql.ppDai.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LOAN_PLAN")
@NoArgsConstructor
public class LoanPlan {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "LISTING_ID")
    private int listingId;

    @Column(name = "PERIODS")
    private short periods;

    @Column(name = "REPAY_STATUS")
    private RepayStatus repayStatus;

    @Column(name = "PRINCIPAL_REPAYABLE")
    private float principalRepayable;//应还本金

    @Column(name = "INTEREST_REPAYABLE")
    private float interestRepayable; //应还利息

    @Column(name = "REMAIN_PRINCIPAL")
    private float remainPrincipal;   //剩余本金

    @Column(name = "REMAIN_INTEREST")
    private float remainInterest;    //剩余利息

    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;         //到期日期

    @Column(name = "REPAY_DATE")
    private Date repayDate;          //还款日期

    @Column(name = "RECORD_DATE")
    private Date recordDate;

    public void setLoanPlanDetail(LoanPlanDetail loanPlanDetail){
        this.listingId = loanPlanDetail.listingId;
        this.periods = loanPlanDetail.periods;
        this.repayStatus = loanPlanDetail.repayStatus;
    }

    public void setPlanPrincipalInterest(PlanPrincipalInterest principalInterest){
        this.principalRepayable = principalInterest.principalRepayable;
        this.interestRepayable = principalInterest.interestRepayable;
        this.remainPrincipal = principalInterest.remainPrincipal;
        this.remainInterest = principalInterest.remainInterest;
    }

    public void setPlanDateDetail(PlanDateDetail planDateDetail){
        this.expiryDate = planDateDetail.expiryDate;
        this.repayDate = planDateDetail.repayDate;
        this.recordDate = planDateDetail.recordDate;
    }

    @Data
    @AllArgsConstructor
    public static class LoanPlanDetail{
        private int listingId;
        private short periods;
        private RepayStatus repayStatus;
    }

    @Data
    @AllArgsConstructor
    public static class PlanPrincipalInterest{
        private float principalRepayable;
        private float interestRepayable;
        private float remainPrincipal;
        private float remainInterest;
    }

    @Data
    @AllArgsConstructor
    public static class PlanDateDetail {
        private Date expiryDate;
        private Date repayDate;
        private Date recordDate;
    }

}
