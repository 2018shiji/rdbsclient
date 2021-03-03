package com.module.mysql.movie.migrate.persistQueue;

import com.module.mysql.movie.entity.*;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Getter
@Component
public class PersistentMovieQueue {
    int capacity = 5000;
    Logger logger = LoggerFactory.getLogger(PersistentMovieQueue.class);

    private BlockingQueue<Movie> movies = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Genre> genres = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Company> companies = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Country> countries = new ArrayBlockingQueue<>(capacity);
    private BlockingQueue<Language> languages = new ArrayBlockingQueue<>(capacity);


    public void offerMovieInTime(Movie movie){
        try{
            movies.offer(movie, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for movie: " + movie + "Exception: " + e.getMessage());
        }
    }

    public void offerGenreInTime(Genre genre){
        try{
            genres.offer(genre, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for genre: " + genre + "Exception: " + e.getMessage());
        }
    }

    public void offerCompanyInTime(Company company){
        try{
            companies.offer(company, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for company: " + company + "Exception: " + e.getMessage());
        }
    }

    public void offerCountryInTime(Country country){
        try{
            countries.offer(country, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for country: " + country + "Exception: " + e.getMessage());
        }
    }

    public void offerLanguageInTime(Language language){
        try{
            languages.offer(language, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e){
            logger.error("insert error for language: " + language + "Exception: " + e.getMessage());
        }
    }


}
