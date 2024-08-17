package com.learning.refactoring;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceGeneratorTest {

    ObjectMapper mapper = new ObjectMapper();
    private InvoiceGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new InvoiceGenerator();
    }

    @Test
    void unknownPlayType() throws IOException {
        //Given
        var invoice = readInvoices("invoices.json").get(0);
        var plays = readPlays("plays_with_unknown_type.json");

        //When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> generator. statement(invoice, plays));

        //Then
        Assertions.assertEquals("unknown play type: sci-fi", exception.getMessage());
    }

    @Test
    void playIdNotFoundInPerformances() throws IOException {
        //Given
        var invoice = readInvoices("invoices_with_unknown_play_id.json").get(0);
        var plays = readPlays("plays.json");;

        //When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> generator. statement(invoice, plays));

        //Then
        Assertions.assertEquals("performance with unknown play id: hamlet2", exception.getMessage());
    }

    @Test
    void generateStatementSuccess() throws IOException {
        //Given
        var invoice = readInvoices("invoices.json").get(0);
        var plays = readPlays("plays.json");

        //When
        String actual = generator.statement(invoice, plays);

        //Then
        String expected = """
                Statement for BigCo
                  Hamlet: $650.00 (55 seats)
                  As You Like It: $580.00 (35 seats)
                  Othello: $500.00 (40 seats)
                Amount owed is $1,730.00
                You earned 47 credits
                """;

        Assertions.assertEquals(expected, actual);
    }

    private Map<String, Play> readPlays(String fileName) throws IOException {
        return mapper.readValue(readJsonFile(fileName), new TypeReference<>() {});
    }

    private List<Invoice> readInvoices(String fileName) throws IOException {
        return mapper.readValue(readJsonFile(fileName), new TypeReference<>() {});
    }

    private String readJsonFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        return FileUtils.readFileToString(file, "UTF-8");
    }

}