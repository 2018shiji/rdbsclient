package com.module.mysql.movie.entity;

import com.module.mysql.movie.entity.oral.OralCompany;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "MOVIE_COMPANY", joinColumns = {
            @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
    })
    private List<Movie> movies;

    public Company(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Company(OralCompany oralCompany){
        this.id = oralCompany.getId();
        this.name = oralCompany.getName();
    }
}
