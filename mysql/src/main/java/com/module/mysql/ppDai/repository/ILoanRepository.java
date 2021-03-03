package com.module.mysql.ppDai.repository;

import com.module.mysql.ppDai.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ILoanRepository extends JpaRepository<Loan, Integer> {

}
