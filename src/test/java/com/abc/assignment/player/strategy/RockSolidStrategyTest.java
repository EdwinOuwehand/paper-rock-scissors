package com.abc.assignment.player.strategy;

import org.junit.jupiter.api.Test;

import static com.abc.assignment.game.Hand.PAPER;
import static com.abc.assignment.game.Hand.ROCK;
import static com.abc.assignment.game.Hand.SCISSORS;
import static com.abc.assignment.game.Result.DRAW;
import static com.abc.assignment.game.Result.LOSE;
import static com.abc.assignment.game.Result.WIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RockSolidStrategyTest {

    @Test
    void getHand() {
        RockSolidStrategy strategy = new RockSolidStrategy();

        assertEquals(ROCK, strategy.getHand(WIN, PAPER));
        assertEquals(ROCK, strategy.getHand(LOSE, SCISSORS));
        assertEquals(ROCK, strategy.getHand(DRAW, ROCK));
    }

    @Test
    void nullable() {
        assertEquals(ROCK, new RockSolidStrategy().getHand(null, null));
    }
}
