package com.module.mysql.ppDai.entity;

public enum RepayStatus {
    DONE("还清"),
    UNDONE("未还清"),
    UNKNOWN("未知");

    private String status;
    RepayStatus(String status){
        this.status = status;
    }
}
