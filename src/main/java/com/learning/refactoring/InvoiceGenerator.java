package com.learning.refactoring;

import com.learning.refactoring.models.*;

import java.util.Map;

import static java.lang.String.format;

/**
 * Image a company of theatrical players who go out to various events performing plays.
 * Typically, a customer will request a few plays and the company charges them based on
 * the size of the audience and the kind of play they perform. There are currently two
 * kinds of plays that the company performs: tragedies and comedies. As well as providing
 * a bill for the performance, the company gives its customers “volume credits” which
 * they can use for discounts on future performances—think of it as a customer loyalty mechanism.
 *
 * <pre>
 * Future requirements:
 * 1. They want a statement printed in HTML
 * 2. The players are looking to perform more kinds of plays: they hope to add history, pastoral,
 *    pastoral-comical, historical- pastoral, tragical-historical, tragical-comical-historical-pastoral,
 *    scene individable, and poem unlimited to their repertoire. This change will affect both the
 *    way their plays are charged for and the way volume credits are calculated
 * <pre/>
 */

public class InvoiceGenerator {
    public String statement(final Invoice invoice, final Map<String, Play> plays) {
        Statement statement = new Statement();
        return statement.renderPlainText(createStatementData(invoice, plays));
    }

    public String htmlStatement(final Invoice invoice, final Map<String, Play> plays) {
        Statement statement = new Statement();
        return statement.renderHtml(createStatementData(invoice, plays));
    }

    private StatementData createStatementData(Invoice invoice, Map<String, Play> plays) {
        StatementData data = new StatementData();
        data.setCustomer(invoice.customer());
        data.setPerformances(invoice.performances().stream().map(v -> enrichPerformance(v, plays)).toList());
        return data;
    }

    private PerformanceExt enrichPerformance(Performance aPerformance, Map<String, Play> plays) {
        Play play = plays.get(aPerformance.playID());
        if (play == null) throw new IllegalArgumentException("performance with unknown play id: " + aPerformance.playID());
        final PerformanceCalculator calculator = createPerformanceCalculator(aPerformance, play);
        var result = new PerformanceExt(aPerformance);
        result.setPlay(calculator.play());
        result.setAmount(calculator.amount());
        result.setVolumeCredit(calculator.volumeCredits());
        return result;
    }

    private PerformanceCalculator createPerformanceCalculator(Performance aPerformance, Play play) {
        return switch (play.type()) {
            case "tragedy" -> new TragedyCalculator(aPerformance, play);
            case "comedy" -> new ComedyCalculator(aPerformance, play);
            default -> throw new IllegalArgumentException("unknown play type: " + play.type());
        };
    }

}
