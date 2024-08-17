package com.learning.refactoring;

import com.learning.refactoring.models.Performance;
import com.learning.refactoring.models.Play;

public class PerformanceCalculator {
    private final Performance performance;
    private final Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public Performance performance() {
        return performance;
    }

    public Play play() {
        return play;
    }

    public double amount() {
        throw new IllegalStateException("sub class responsibility");
    }

    public int volumeCredits() {
        return Math.max(performance.audience() - 30, 0);
    }
}
