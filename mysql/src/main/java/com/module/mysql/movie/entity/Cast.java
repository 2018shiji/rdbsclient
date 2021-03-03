package com.module.mysql.movie.entity;

import com.module.mysql.movie.entity.oral.OralCast;

import javax.persistence.*;

/**
 * 角色表
 */
@Entity
@Table(name = "CAST")
public class Cast {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "CAST_ID")
    private int castId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREDIT_ID")
    private Credit creditId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACTOR_ID")
    private Actor actor;

    @Column(name="ORDER")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int order;

    @Column(name="CHARACTER")
    private String character;

    public Cast(OralCast oralCast){
        id = oralCast.getCast_id();
        movie = new Movie(oralCast.getMovieId());
        creditId = new Credit(oralCast.getCredit_id());
        actor = new Actor(oralCast.getId());
        order = oralCast.getOrder();
        character = oralCast.getCharacter();
    }
}
