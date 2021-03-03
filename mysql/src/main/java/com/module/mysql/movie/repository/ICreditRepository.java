package com.module.mysql.movie.repository;

import com.module.mysql.movie.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditRepository extends JpaRepository<Credit, Long> {

}
