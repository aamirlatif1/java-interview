package com.learning.refactoring;

import java.util.List;

public class Invoice {
    private String customer;
    private List<Performance> performances;

    public Invoice() {

    }

    public String customer() {
        return customer;
    }

    public List<Performance> performances() {
        return performances;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setPerformances(List<Performance> performances) {
        this.performances = performances;
    }
}