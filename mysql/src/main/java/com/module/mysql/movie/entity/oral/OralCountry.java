package com.module.mysql.movie.entity.oral;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * [{"iso_3166_1": "US", "name": "United States of America"}, {"iso_3166_1": "GB", "name": "United Kingdom"}]
 */
@Data
public class OralCountry {
    @JSONField(name = "iso_3166_1")
    private String code;
    @JSONField(name = "name")
    private String name;
}
