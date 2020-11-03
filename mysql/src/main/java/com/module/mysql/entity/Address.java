package com.module.mysql.entity;

import java.util.Date;
import java.util.List;

public class Address {
    private String address;
    private String address2;
    private int district;
    private String postalCode;
    private String phone;
    private City city;
    private Store store;
    private List<Customer> customers;
    private List<Staff> staffs;

    private Date lastUpdate;
}
