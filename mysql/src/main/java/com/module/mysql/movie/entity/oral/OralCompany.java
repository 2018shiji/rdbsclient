package com.module.mysql.movie.entity.oral;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * [{"name": "Ingenious Film Partners", "id": 289}, {"name": "Twentieth Century Fox Film Corporation", "id": 306}, {"name": "Dune Entertainment", "id": 444}]
 */
@Data
public class OralCompany {
    @JSONField(name = "id")
    private int id;
    @JSONField(name = "name")
    private String name;
}
