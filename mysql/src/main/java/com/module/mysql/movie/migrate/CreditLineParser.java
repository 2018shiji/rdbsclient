package com.module.mysql.movie.migrate;

import com.alibaba.fastjson.JSONArray;
import com.module.mysql.movie.entity.oral.OralCast;
import com.module.mysql.movie.entity.oral.OralCrew;
import com.module.mysql.movie.migrate.streamconsumer.OralCastConsumer;
import com.module.mysql.movie.migrate.streamconsumer.OralCrewConsumer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CreditLineParser {

    private List<String> tableHeader = new ArrayList<>();

    public void parseCreditHeader(String[] header){

    }

    public void parseCreditContent(String[] line){
        transToPojoList(line);


    }

    private void transToPojoList(String[] line){
        if(line == null || line.length == 0)
            return;

        int movieId = Integer.parseInt(line[0]);
        String title = line[1];
        String cast = line[2];
        String crew = line[3];

        JSONArray castArray = JSONArray.parseArray(cast);
        List<OralCast> oralCasts = castArray.toJavaList(OralCast.class);
        oralCasts.stream().forEach(item -> {
            item.setMovieId(movieId);
            item.setMovieTitle(title);
        });
        oralCasts.stream().forEach(new OralCastConsumer());

        JSONArray crewArray = JSONArray.parseArray(crew);
        List<OralCrew> oralCrews = crewArray.toJavaList(OralCrew.class);
        oralCrews.stream().forEach(item -> {
            item.setMovieId(movieId);
            item.setMovieTitle(title);
        });
        oralCrews.stream().forEach(new OralCrewConsumer());

    }


}
