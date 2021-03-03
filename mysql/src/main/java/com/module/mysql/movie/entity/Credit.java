package com.module.mysql.movie.entity;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT")
public class Credit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "CREDIT_ID")
    private String creditId;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "CREW_ID")
    private Crew crew;

    public Credit(String creditId){
        this.creditId = creditId;
    }

}
