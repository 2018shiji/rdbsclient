package com.module.mysql.movie.migrate.streamconsumer;

import com.module.mysql.movie.entity.Genre;
import com.module.mysql.movie.entity.oral.OralGenre;
import com.module.mysql.movie.migrate.persistQueue.PersistentMovieQueue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;

@Component
public class OralGenreConsumer implements Consumer<OralGenre> {
    @Autowired
    PersistentMovieQueue movieQueue;
    @Getter @Setter
    private List<Genre> genres;

    @Override
    public void accept(OralGenre oralGenre) {
        Genre genre = new Genre(oralGenre);
        genres.add(genre);
        movieQueue.offerGenreInTime(genre);
    }
}
