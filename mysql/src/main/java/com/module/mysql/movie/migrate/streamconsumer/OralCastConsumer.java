package com.module.mysql.movie.migrate.streamconsumer;

import com.module.mysql.movie.entity.*;
import com.module.mysql.movie.entity.oral.OralCast;
import com.module.mysql.movie.migrate.persistQueue.PersistentCastQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class OralCastConsumer implements Consumer<OralCast> {
    @Autowired
    PersistentCastQueue persistQueue;

    @Override
    public void accept(OralCast oralCast) {
        persistQueue.offerActorInTime(new Actor(oralCast));
        persistQueue.offerCastInTime(new Cast(oralCast));
        persistQueue.offerCreditInTime(new Credit(oralCast.getCredit_id()));
        persistQueue.offerMovieInTime(new Movie(oralCast.getMovieId()));

    }
}
