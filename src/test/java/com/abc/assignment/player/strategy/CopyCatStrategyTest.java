package com.abc.assignment.player.strategy;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CopyCatStrategyTest {

    @ParameterizedTest
    @CsvSource({
        "WIN,  ROCK,        SCISSORS",
        "WIN,  PAPER,       ROCK",
        "WIN,  SCISSORS,    PAPER",
        "LOSE, ROCK,        PAPER",
        "LOSE, PAPER,       SCISSORS",
        "LOSE, SCISSORS,    ROCK",
        "DRAW, ROCK,        ROCK",
        "DRAW, PAPER,       PAPER",
        "DRAW, SCISSORS,    SCISSORS"
    })
    void getHand(Result lastResult, Hand lastPlayed, Hand expected) {
        assertEquals(expected, new CopyCatStrategy().getHand(lastResult, lastPlayed));
    }

    @Test
    void nullable() {
        assertDoesNotThrow(() -> new CopyCatStrategy().getHand(null, null));
    }
}
