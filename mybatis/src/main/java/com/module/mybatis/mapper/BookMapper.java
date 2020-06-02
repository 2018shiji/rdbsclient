package com.module.mybatis.mapper;


import com.module.mybatis.entity.Entity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookMapper {
    int insert(Entity record);
    List<Entity> selectAll();
    Entity getById(Integer id);
}
