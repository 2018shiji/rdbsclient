package com.module.mysql.ppDai.entity;

public enum Certification {
    SUCCESS("成功认证"),
    FAILURE("未成功认证");

    private String status;
    Certification(String status){
        this.status = status;
    }
}
