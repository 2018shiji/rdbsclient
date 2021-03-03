package com.module.mysql.movie.entity.oral;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * [{"iso_639_1": "en", "name": "English"}, {"iso_639_1": "es", "name": "Espa\u00f1ol"}]
 */
@Data
public class OralLanguage {
    @JSONField(name = "iso_639_1")
    private String code;
    @JSONField(name = "name")
    private String name;
}
