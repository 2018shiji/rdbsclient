package com.module.mysql.movie.migrate;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class OralMovieCsvReader {
    @Autowired
    private CreditLineParser creditLineParser;
    @Autowired
    private MovieLineParser movieLineParser;

    public void readMovies(){
        String[] line;
        try{
            CSVReader reader = new CSVReader(new FileReader("F:\\DBData\\movie\\tmdb_5000_movies.csv"));
            movieLineParser.parseMovieHeader(reader.readNext());

            while((line = reader.readNext()) != null){
                movieLineParser.parseMovieContent(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readCredits(){
        String[] line;
        try {
            CSVReader reader = new CSVReader(new FileReader("F:\\DBData\\movie\\tmdb_5000_credits.csv"));
            creditLineParser.parseCreditHeader(reader.readNext());

            while ((line = reader.readNext()) != null) {
                creditLineParser.parseCreditContent(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
