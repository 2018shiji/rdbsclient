package com.module.mysql.entity;

import java.util.Date;
import java.util.List;

public class Customer {
    private int addressColumn;
    private String firstName;
    private String lastName;
    private String email;
    private char active;
    private Address address;
    private List<Payment> payments;
    private List<Rental> rentals;

    private Date createDate;
    private Date lastUpdate;
}
