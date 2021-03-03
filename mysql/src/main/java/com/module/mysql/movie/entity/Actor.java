package com.module.mysql.movie.entity;

import com.module.mysql.movie.entity.oral.OralCast;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 演员表
 */
@Entity
@Table(name = "ACTOR")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    @Column(name="ACTOR_NAME")
    private String name;

    @Column(name="ACTOR_GENDER")
    private Gender gender;

    public Actor(int id){
        this.id = id;
    }

    public Actor(OralCast oralCast){
        id = oralCast.getId();
        name = oralCast.getName();

        int genderId = oralCast.getGender();
        switch(genderId) {
            case 0:
                gender = Gender.FEMALE;
                break;
            case 1:
                gender = Gender.MALE;
            default:
                gender = Gender.UNKNOWN;
        }
    }

}
