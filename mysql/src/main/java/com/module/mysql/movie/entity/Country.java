package com.module.mysql.movie.entity;

import com.module.mysql.movie.entity.oral.OralCountry;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY")
public class Country {
    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "MOVIE_COUNTRY", joinColumns = {
            @JoinColumn(name = "COUNTRY_CODE", referencedColumnName = "CODE")}, inverseJoinColumns = {
            @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
    })
    private List<Movie> movies;

    public Country(String code, String name){
        this.code = code;
        this.name = name;
    }

    public Country(OralCountry oralCountry){
        this.code = oralCountry.getCode();
        this.name = oralCountry.getName();
    }
}
