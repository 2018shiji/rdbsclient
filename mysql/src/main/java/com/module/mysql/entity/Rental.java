package com.module.mysql.entity;

import java.util.Date;
import java.util.List;

public class Rental {
    private Staff staff;
    private Customer customer;
    private Inventory inventory;
    private List<Payment> payments;

    private Date rentalDate;
    private Date returnDate;
    private Date lastUpdate;
}
