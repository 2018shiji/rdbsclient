package com.module.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity {
    private Integer id;
    private String name;
    private String author;
    private Double price;



}
