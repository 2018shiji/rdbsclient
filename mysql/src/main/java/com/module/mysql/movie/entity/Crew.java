package com.module.mysql.movie.entity;

import com.module.mysql.movie.entity.oral.OralCrew;

import javax.persistence.*;

@Entity
@Table(name = "CREW")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    @Column(name="CREW_NAME")
    private String name;

    @Column(name="CREW_GENDER")
    private Gender gender;

    @OneToOne
    @JoinColumn(name="DEPTJOB_ID")
    private DeptJob deptJob;

    public Crew(OralCrew oralCrew){
        id = oralCrew.getId();
        name = oralCrew.getName();
        deptJob = new DeptJob(oralCrew.getDepartment(), oralCrew.getJob());

        int genderId = oralCrew.getGender();
        switch(genderId){
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
