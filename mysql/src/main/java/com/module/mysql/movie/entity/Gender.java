package com.module.mysql.movie.entity;

public enum Gender {
    UNKNOWN("未知"),
    MALE("男"),
    FEMALE("女");

    private String identifier;
    Gender(String identifier){
        this.identifier = identifier;
    }
}
