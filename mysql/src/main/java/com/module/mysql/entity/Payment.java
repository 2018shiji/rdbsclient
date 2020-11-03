package com.module.mysql.entity;

import java.util.Date;

public class Payment {
    private double amount;
    private Rental rental;
    private Customer customer;
    private Staff staff;

    private Date paymentDate;
}
