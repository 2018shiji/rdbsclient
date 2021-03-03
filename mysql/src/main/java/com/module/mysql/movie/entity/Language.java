package com.module.mysql.movie.entity;

import com.module.mysql.movie.entity.oral.OralLanguage;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LANGUAGE")
public class Language {
    @Id
    @Column(name = "CODE")
    private String code;
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "MOVIE_LANGUAGE", joinColumns = {
            @JoinColumn(name = "LANGUAGE_CODE", referencedColumnName = "CODE")}, inverseJoinColumns = {
            @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
    })
    private List<Movie> movies;

    public Language(String code, String name){
        this.code = code;
        this.name = name;
    }

    public Language(OralLanguage oralLanguage){
        this.code = oralLanguage.getCode();
        this.name = oralLanguage.getName();
    }
}
