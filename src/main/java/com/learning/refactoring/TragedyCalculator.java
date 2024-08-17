package com.learning.refactoring;

import com.learning.refactoring.models.Performance;
import com.learning.refactoring.models.Play;

public class TragedyCalculator extends PerformanceCalculator{
    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public double amount() {
        var result = 40000.0;
        if (performance().audience() > 30) {
            result += 1000 * (performance().audience() - 30);
        }
        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits();
    }
}
