package com.module.mysql.movie.entity;

import com.module.mysql.movie.entity.oral.OralGenre;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GENRE")
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "CATEGORY")
    private String category;

    @ManyToMany
    @JoinTable(name = "MOVIE_GENRE", joinColumns = {
            @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
    })
    private List<Movie> movies;

    public Genre(int id, String category){
        this.id = id;
        this.category = category;
    }

    public Genre(OralGenre oralGenre){
        this.id = oralGenre.getId();
        this.category = oralGenre.getName();
    }
}
