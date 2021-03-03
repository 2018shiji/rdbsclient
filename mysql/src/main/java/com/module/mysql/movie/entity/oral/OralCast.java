package com.module.mysql.movie.entity.oral;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [{"cast_id": 242, "character": "Jake Sully", "credit_id": "5602a8a7c3a3685532001c9a", "gender": 2, "id": 65731, "name": "Sam Worthington", "order": 0}]
 */
@Data
public class OralCast {
    @JSONField(name = "cast_id")
    private int cast_id;
    @JSONField(name = "character")
    private String character;
    @JSONField(name = "credit_id")
    private String credit_id;
    @JSONField(name = "gender")
    private int gender;
    @JSONField(name = "id")
    private int id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "order")
    private int order;

    private int movieId;
    private String movieTitle;
}
