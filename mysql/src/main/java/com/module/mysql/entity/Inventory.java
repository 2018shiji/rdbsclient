package com.module.mysql.entity;

import java.util.Date;
import java.util.List;

public class Inventory {
    private Film film;
    private List<Rental> rentals;

    private Date lastUpdate;
}
