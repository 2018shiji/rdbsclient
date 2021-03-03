package com.module.mysql.ppDai.repository;

import com.module.mysql.ppDai.entity.LoanPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ILoanPlanRepository extends JpaRepository<LoanPlan, Integer> {

}
