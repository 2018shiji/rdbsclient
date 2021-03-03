package com.module.mysql.movie.repository;

import com.module.mysql.movie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

}
