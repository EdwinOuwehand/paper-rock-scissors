package com.abc.assignment.player.strategy;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;

import static com.abc.assignment.game.Hand.ROCK;

public class RockSolidStrategy implements Strategy {

    @Override
    public Hand getHand(Result lastResult, Hand lastPlayed) {
        return ROCK;
    }
}
