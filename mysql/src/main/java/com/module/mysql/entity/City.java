package com.module.mysql.entity;

import java.util.Date;
import java.util.List;

public class City {
    private String city;
    private Country country;
    private List<Address> addresses;
    private Date lastUpdate;
}
