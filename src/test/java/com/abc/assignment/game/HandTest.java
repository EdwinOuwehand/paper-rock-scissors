package com.abc.assignment.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTest {

    @ParameterizedTest
    @CsvSource({
        "ROCK,      SCISSORS,   WIN",
        "ROCK,      PAPER,      LOSE",
        "ROCK,      ROCK,       DRAW",
        "SCISSORS,  PAPER,      WIN",
        "SCISSORS,  ROCK,       LOSE",
        "SCISSORS,  SCISSORS,   DRAW",
        "PAPER,     ROCK,       WIN",
        "PAPER,     SCISSORS,   LOSE",
        "PAPER,     PAPER,      DRAW"
    })
    void compete(Hand mine, Hand yours, Result result) {
        assertEquals(result, mine.compete(yours));
    }
}
