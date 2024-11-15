package com.abc.assignment.player.strategy;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static com.abc.assignment.game.Hand.PAPER;
import static com.abc.assignment.game.Hand.ROCK;
import static com.abc.assignment.game.Hand.SCISSORS;
import static com.abc.assignment.game.Result.DRAW;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningStrategyTest {

    @ParameterizedTest
    @CsvSource({
        "WIN,  ROCK,     SCISSORS",
        "WIN,  PAPER,    ROCK",
        "WIN,  SCISSORS, PAPER",
        "LOSE, ROCK,     SCISSORS",
        "LOSE, PAPER,    ROCK",
        "LOSE, SCISSORS, PAPER"
    })
    void getHandWinLoss(Result lastResult, Hand lastPlayed, Hand expected) {
        Hand hand = new WinningStrategy().getHand(lastResult, lastPlayed);
        assertEquals(expected, hand);
    }

    @ParameterizedTest
    @EnumSource(Hand.class)
    void getHandDraw(Hand lastPlayed) {
        Hand hand = new WinningStrategy().getHand(DRAW, lastPlayed);
        assertTrue(hand == ROCK || hand == PAPER || hand == SCISSORS);
    }

    @Test
    void nullable() {
        assertDoesNotThrow(() -> new WinningStrategy().getHand(null, null));
    }
}
