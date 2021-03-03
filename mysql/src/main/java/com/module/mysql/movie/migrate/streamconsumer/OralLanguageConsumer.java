package com.module.mysql.movie.migrate.streamconsumer;

import com.module.mysql.movie.entity.Language;
import com.module.mysql.movie.entity.oral.OralLanguage;
import com.module.mysql.movie.migrate.persistQueue.PersistentMovieQueue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Consumer;

public class OralLanguageConsumer implements Consumer<OralLanguage> {
    @Autowired
    PersistentMovieQueue movieQueue;
    @Getter @Setter
    private List<Language> languages;

    @Override
    public void accept(OralLanguage oralLanguage) {
        Language language = new Language(oralLanguage);
        languages.add(language);
        movieQueue.offerLanguageInTime(language);
    }

}
