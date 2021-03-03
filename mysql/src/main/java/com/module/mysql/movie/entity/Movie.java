package com.module.mysql.movie.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "BUDGET")
    private int budget;

    @OneToMany
    @JoinColumn(name = "MOVIE_CAST_ID", referencedColumnName = "ID")
    private List<Cast> casts;

    @OneToMany
    @JoinColumn(name = "MOVIE_CREDIT_ID", referencedColumnName = "ID")
    private List<Credit> credits;

    @ManyToMany
    private List<Genre> genres;

    @Column(name = "HOMEPAGE")
    private String homepage;                            //movie detail

    @Column(name = "KEYWORDS")
    private String keywords;                            //movie detail

    @Column(name = "ORIGINAL_LANGUAGE")
    private String originalLanguage;                    //movie detail

    @Column(name = "ORIGINAL_TITLE")
    private String originalTitle;                       //movie detail

    @Column(name = "OVERVIEW")
    private String overview;                            //movie detail

    @Column(name = "POPULARITY")
    private double popularity;                          //movie perform

    @ManyToMany
    private List<Company> productCompanies;             //movie perform

    @ManyToMany
    private List<Country> productCountries;             //movie perform

    @Column(name = "RELEASE_DATE")
    private String releaseDate;                         //movie perform

    @Column(name = "REVENUE")
    private long revenue;                               //movie perform

    @Column(name = "RUNTIME")
    private int runtime;                                //movie detail

    @ManyToMany
    private List<Language> spokenLanguages;             //movie perform

    @Column(name = "STATUS")
    private MovieStatus movieStatus;                    //movie perform

    @Column(name = "TAGLINE")
    private String tagLine;                             //movie detail

    @Column(name = "TITLE")
    private String title;                               //movie detail

    @Column(name = "VOTE_AVERAGE")
    private float voteAverage;                          //movie perform

    @Column(name = "VOTE_COUNT")
    private int voteCount;                              //movie perform

    public Movie(int id){
        this.id = id;
    }

    public Movie(int id, int budget, List<Genre> genres){
        this.id = id;
        this.budget = budget;
        this.genres = genres;
    }

    public void setMovieCastAndCredit(List<Cast> casts, List<Credit> credits){
        this.casts = casts;
        this.credits = credits;
    }

    public void setMovieDetail(MovieDetail movieDetail){
        this.id = movieDetail.id == 0 ? this.id : movieDetail.id;
        this.homepage = movieDetail.homepage;
        this.keywords = movieDetail.keywords;
        this.originalLanguage = movieDetail.oralLanguage;
        this.originalTitle = movieDetail.oralTitle;
        this.overview = movieDetail.overview;
        this.runtime = movieDetail.runtime;
        this.tagLine = movieDetail.tagLine;
        this.title = movieDetail.title;
    }

    public void setMoviePerform(MoviePerform moviePerform){
        this.id = moviePerform.id == 0 ? this.id : moviePerform.id;
        this.popularity = moviePerform.popularity;
        this.productCompanies = moviePerform.productCompanies;
        this.productCountries = moviePerform.productCountries;
        this.releaseDate = moviePerform.releaseDate;
        this.revenue = moviePerform.revenue;
        this.spokenLanguages = moviePerform.spokenLanguages;
        this.movieStatus = moviePerform.movieStatus;
        this.voteAverage = moviePerform.voteAverage;
        this.voteCount = moviePerform.voteCount;
    }

    @Data
    public static class MovieDetail{
        private int id;
        private String homepage;
        private String keywords;
        private String oralLanguage;
        private String oralTitle;
        private String overview;
        private int runtime;
        private String tagLine;
        private String title;

        public MovieDetail(String homepage, String keywords, String oralLanguage, String oralTitle, String overview, int runtime, String tagLine, String title){
            this(0, homepage, keywords, oralLanguage, oralTitle, overview, runtime, tagLine, title);
        }
        public MovieDetail(int id, String homepage, String keywords, String oralLanguage, String oralTitle, String overview, int runtime, String tagLine, String title){
            this.id = id;
            this.homepage = homepage;
            this.keywords = keywords;
            this.oralLanguage = oralLanguage;
            this.oralTitle = oralTitle;
            this.overview = overview;
            this.runtime = runtime;
            this.tagLine = tagLine;
            this.title = title;
        }
    }

    @Data
    public static class MoviePerform{
        private int id;
        private double popularity;
        private List<Company> productCompanies;
        private List<Country> productCountries;
        private String releaseDate;
        private long revenue;
        private List<Language> spokenLanguages;
        private MovieStatus movieStatus;
        private float voteAverage;
        private int voteCount;
        public MoviePerform(double popularity, List<Company> productCompanies, List<Country> productCountries, String releaseDate, long revenue,
                            List<Language> spokenLanguages, MovieStatus movieStatus, float voteAverage, int voteCount){
            this(0, popularity, productCompanies, productCountries, releaseDate, revenue, spokenLanguages, movieStatus, voteAverage, voteCount);
        }
        public MoviePerform(int id, double popularity, List<Company> productCompanies, List<Country> productCountries, String releaseDate, long revenue,
                            List<Language> spokenLanguages, MovieStatus movieStatus, float voteAverage, int voteCount){
            this.id = id;
            this.popularity = popularity;
            this.productCompanies = productCompanies;
            this.productCountries = productCountries;
            this.releaseDate = releaseDate;
            this.revenue = revenue;
            this.spokenLanguages = spokenLanguages;
            this.movieStatus = movieStatus;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
        }
    }
}
