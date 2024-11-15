package com.abc.assignment.player.strategy;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomStrategyTest {

    @ParameterizedTest
    @CsvSource({
        "WIN,  ROCK",
        "WIN,  PAPER",
        "WIN,  SCISSORS",
        "LOSE, ROCK",
        "LOSE, PAPER",
        "LOSE, SCISSORS",
        "DRAW, ROCK",
        "DRAW, PAPER",
        "DRAW, SCISSORS"
    })
    void getHand(Result lastResult, Hand lastPlayed) {
        RandomStrategy strategy = new RandomStrategy();
        Hand hand = strategy.getHand(lastResult, lastPlayed);

        assertTrue(hand == Hand.ROCK || hand == Hand.PAPER || hand == Hand.SCISSORS);
    }

    @Test
    void nullable() {
        assertDoesNotThrow(() -> new RandomStrategy().getHand(null, null));
    }
}
