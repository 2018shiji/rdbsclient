package com.module.mysql.movie.entity.oral;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [{"credit_id": "52fe48009251416c750aca23", "department": "Editing", "gender": 0, "id": 1721, "job": "Editor", "name": "Stephen E. Rivkin"}
 */
@Data
public class OralCrew {
    @JSONField(name = "credit_id")
    private String credit_id;
    @JSONField(name = "department")
    private String department;
    @JSONField(name = "gender")
    private int gender;
    @JSONField(name = "id")
    private int id;
    @JSONField(name = "job")
    private String job;
    @JSONField(name = "name")
    private String name;

    private long movieId;
    private String movieTitle;
}
