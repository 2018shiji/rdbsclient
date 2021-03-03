package com.module.mysql.movie.migrate.persistQueue;

import com.module.mysql.movie.entity.Actor;
import com.module.mysql.movie.entity.Cast;
import com.module.mysql.movie.entity.Credit;
import com.module.mysql.movie.entity.Movie;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * [{"cast_id": 242, "character": "Jake Sully", "credit_id": "5602a8a7c3a3685532001c9a", "gender": 2, "id": 65731, "name": "Sam Worthington", "order": 0}]
 */
@Getter
@Component
public class PersistentCastQueue {
    int capacity = 5000;
    Logger logger = LoggerFactory.getLogger(PersistentCastQueue.class);
    private BlockingQueue<Actor> actors = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Cast> casts = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Credit> credits = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Movie> movies = new ArrayBlockingQueue<>(capacity);


    public void offerActorInTime(Actor actor){
        try {
            actors.offer(actor, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for actor: " + actor + "Exception: " + e.getMessage());
        }
    }

    public void offerCastInTime(Cast cast){
        try {
            casts.offer(cast, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for cast: " + cast + "Exception: " + e.getMessage());
        }
    }

    public void offerCreditInTime(Credit credit){
        try{
            credits.offer(credit, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for credit: " + credit + "Exception: " + e.getMessage());
        }
    }

    public void offerMovieInTime(Movie movie){
        try{
            movies.offer(movie, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for movie: " + movie + "Exception: " + e.getMessage());
        }
    }

}
