package com.module.mongo.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String name;

    private Integer age;

}
