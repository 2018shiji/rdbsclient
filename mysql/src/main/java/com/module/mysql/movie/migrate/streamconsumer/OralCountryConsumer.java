package com.module.mysql.movie.migrate.streamconsumer;

import com.module.mysql.movie.entity.Country;
import com.module.mysql.movie.entity.oral.OralCountry;
import com.module.mysql.movie.migrate.persistQueue.PersistentMovieQueue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Consumer;

public class OralCountryConsumer implements Consumer<OralCountry> {
    @Autowired
    PersistentMovieQueue movieQueue;
    @Getter @Setter
    private List<Country> countries;

    @Override
    public void accept(OralCountry oralCountry) {
        Country country = new Country(oralCountry);
        countries.add(country);
        movieQueue.offerCountryInTime(country);
    }

}
