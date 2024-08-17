package com.learning.refactoring;

import com.learning.refactoring.models.PerformanceExt;
import com.learning.refactoring.models.StatementData;

import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.String.format;

class Statement {

    public String renderPlainText(StatementData data) {
        var result = new StringBuilder(format("Statement for %s%n", data.customer()));
        for (PerformanceExt perf : data.performances()) {
            result.append(format("  %s: %s (%d seats)%n", perf.play().name(), usd(perf.amount()), perf.audience()));
        }
        result.append(format("Amount owed is %s%n", usd(data.totalAmount())));
        result.append(format("You earned %d credits%n", data.totalVolumeCredits()));
        return result.toString();
    }

    public String renderHtml(StatementData data) {
        var result = new StringBuilder(format("<h1>Statement for %s</h1>%n", data.customer()));
        result.append("<table>\n<tr><th>play</th><th>seats</th><th>cost</th></tr>\n");
        for (PerformanceExt perf : data.performances()) {
            result.append(format("<tr><td>%s</td><td>%s</td><td>%d</td></tr>%n", perf.play().name(), usd(perf.amount()), perf.audience()));
        }
        result.append("</table>\n");
        result.append(format("<p>Amount owed is <em>%s</em></p>%n", usd(data.totalAmount())));
        result.append(format("<p>You earned <em>%d</em> credits</p>%n", data.totalVolumeCredits()));
        return result.toString();
    }

    private static String usd(double thisAmount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(thisAmount / 100.0);
    }

}
