package com.module.mysql.movie.migrate;

import com.alibaba.fastjson.JSONArray;
import com.module.mysql.movie.entity.*;
import com.module.mysql.movie.entity.oral.OralCompany;
import com.module.mysql.movie.entity.oral.OralCountry;
import com.module.mysql.movie.entity.oral.OralGenre;
import com.module.mysql.movie.entity.oral.OralLanguage;
import com.module.mysql.movie.migrate.persistQueue.PersistentMovieQueue;
import com.module.mysql.movie.migrate.streamconsumer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieLineParser {
    @Autowired
    private PersistentMovieQueue movieQueue;

    private List<String> tableHeader = new ArrayList<>();

    public void parseMovieHeader(String[] header){

    }

    public void parseMovieContent(String[] line){
        transToPojoList(line);

    }

    private void transToPojoList(String[] line){
        if(line == null || line.length == 0)
            return;

        int budget = Integer.parseInt(line[0]);
        String genreStr = line[1];                         //json list
        List<Genre> genres = new ArrayList<>();
        OralGenreConsumer oralGenreConsumer = new OralGenreConsumer();
        oralGenreConsumer.setGenres(genres);
        List<OralGenre> genreList = jsonToObjArray(genreStr, OralGenre.class);
        genreList.stream().forEach(oralGenreConsumer);

        String homepage = line[2];
        int id = Integer.parseInt(line[3]);
        String keywords = line[4];                       //json list toString
        String oralLanguage = line[5];
        String oralTitle = line[6];
        String overview = line[7];
        double popularity = Double.parseDouble(line[8]);

        String productCompanies = line[9];               //json list
        List<Company> companies = new ArrayList<>();
        OralCompanyConsumer oralCompanyConsumer = new OralCompanyConsumer();
        oralCompanyConsumer.setCompanies(companies);
        List<OralCompany> productCompList = jsonToObjArray(productCompanies, OralCompany.class);
        productCompList.stream().forEach(oralCompanyConsumer);

        String productCountries = line[10];              //json list
        List<Country> countries = new ArrayList();
        OralCountryConsumer oralCountryConsumer = new OralCountryConsumer();
        oralCountryConsumer.setCountries(countries);
        List<OralCountry> productCountryList = jsonToObjArray(productCountries, OralCountry.class);
        productCountryList.stream().forEach(oralCountryConsumer);

        String releaseDate = line[11];
        long revenue = Long.parseLong(line[12]);
        int runtime = Integer.parseInt(line[13]);

        String spokenLanguages = line[14];               //json list
        List<Language> languages = new ArrayList<>();
        OralLanguageConsumer oralLangConsumer = new OralLanguageConsumer();
        oralLangConsumer.setLanguages(languages);
        List<OralLanguage> spokenLanguageList = jsonToObjArray(spokenLanguages, OralLanguage.class);
        spokenLanguageList.stream().forEach(oralLangConsumer);
        System.out.println(languages);

        String status = line[15];
        String tagLine = line[16];
        String title = line[17];
        float voteAverage = Float.parseFloat(line[18]);
        int voteCount = Integer.parseInt(line[19]);

        Movie.MovieDetail movieDetail = new Movie.MovieDetail(homepage, keywords, oralLanguage, oralTitle,
                overview, runtime, tagLine, title);

        Movie.MoviePerform moviePerform = new Movie.MoviePerform(popularity, oralCompanyConsumer.getCompanies(),
                oralCountryConsumer.getCountries(), releaseDate, revenue, languages, getMovieStatus(status), voteAverage, voteCount);

        Movie movie = new Movie(id, budget, oralGenreConsumer.getGenres());
        movie.setMovieDetail(movieDetail);
        movie.setMoviePerform(moviePerform);

        movieQueue.offerMovieInTime(movie);
    }

    private <T> List<T> jsonToObjArray(String jsonString, Class<T> targetClass){
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        List<T> targetList = jsonArray.toJavaList(targetClass);
        return targetList;
    }

    private MovieStatus getMovieStatus(String status){
        if(status.equals("released")){
            return MovieStatus.RELEASED;
        } else {
            return MovieStatus.UNKNOWN;
        }
    }

}
