package com.module.mysql.movie.entity;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE_DEPT_JOB")
public class DeptJob {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "DEPT_NAME")
    private String deptName;

    @Column(name = "JOB_NAME")
    private String jobName;

    public DeptJob(String deptName, String jobName){
        this.deptName = deptName;
        this.jobName = jobName;
    }
}
