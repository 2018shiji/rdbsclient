package com.module.mysql.navigator;

import com.module.mysql.movie.repository.IActorRepository;
import com.module.mysql.movie.repository.ICreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieNavigator {
    @Autowired
    IActorRepository actorRepo;
    @Autowired
    ICreditRepository creditRepo;

    @ResponseBody
    @RequestMapping("migrateMovieSingle")
    public String migrateMovieSingle(){
        return "success";
    }

    @ResponseBody
    @RequestMapping("migrateMovieBatch")
    public String migrateMovieBatch(){
        return "success";
    }
}
