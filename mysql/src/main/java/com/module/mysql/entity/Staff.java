package com.module.mysql.entity;

import java.util.Date;
import java.util.List;

public class Staff {
    private String firstName;
    private String lastName;
    private String email;
    private char active;
    private String userName;
    private String password;
    private String pictureUrl;
    private Address address;
    private Store store;
    private List<Payment> payments;
    private List<Rental> rentals;

    private Date lastUpdate;
}
