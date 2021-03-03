package com.module.mysql.movie.entity;


public enum MovieStatus {
    RELEASED("Released"),
    UNKNOWN("Unknown");

    String describe;
    MovieStatus(String describe){
        this.describe = describe;
    }
}
