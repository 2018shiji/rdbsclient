package com.module.mysql.entity;

import java.util.Date;
import java.util.List;

public class Film {
    private String title;
    private String description;
    private int releaseYear;
    private double rentalRate;
    private int length;
    private double replacementCost;
    private int rating;
    private String specialFeatures;
    private String fulltext;
    private Language language;
    private List<Inventory> inventories;
    private List<Category> categories;
    private List<Actor> actors;
    private Date lastUpdate;

}
