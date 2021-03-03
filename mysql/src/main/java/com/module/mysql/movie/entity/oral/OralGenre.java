package com.module.mysql.movie.entity.oral;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * [{"id": 28, "name": "Action"}, {"id": 12, "name": "Adventure"}, {"id": 14, "name": "Fantasy"}, {"id": 878, "name": "Science Fiction"}]
 */
@Data
public class OralGenre {
    @JSONField(name = "id")
    private int id;
    @JSONField(name = "name")
    private String name;
}
