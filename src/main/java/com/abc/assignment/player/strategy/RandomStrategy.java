package com.abc.assignment.player.strategy;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;

public class RandomStrategy implements Strategy {

    @Override
    public Hand getHand(Result lastResult, Hand lastPlayed) {
        return Hand.random();
    }
}
