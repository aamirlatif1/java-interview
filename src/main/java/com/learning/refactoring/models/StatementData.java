package com.learning.refactoring.models;

import java.util.List;

public class StatementData {
    private String customer;

    private List<PerformanceExt> performances;

    public String customer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    public List<PerformanceExt> performances() {
        return performances;
    }

    public void setPerformances(List<PerformanceExt> performances) {
        this.performances = performances;
    }

    public double totalAmount() {
        var result = 0.0;
        for (PerformanceExt perf : performances()) {
            result += perf.amount();
        }
        return result;
    }

    public int totalVolumeCredits() {
        var volumeCredits = 0;
        for (PerformanceExt perf : performances()) {
            volumeCredits += perf.volumeCredit();
        }
        return volumeCredits;
    }

}
