package com.learning.refactoring.models;

import com.learning.refactoring.models.Performance;
import com.learning.refactoring.models.Play;

public class PerformanceExt extends Performance {
    private Play play;
    private double amount;
    private double volumeCredit;
    public PerformanceExt(Performance performance){
        this.setAudience(performance.audience());
        this.setPlayID(performance.playID());
    }

    public Play play() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public double amount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double volumeCredit() {
        return volumeCredit;
    }

    public void setVolumeCredit(double volumeCredit) {
        this.volumeCredit = volumeCredit;
    }
}
