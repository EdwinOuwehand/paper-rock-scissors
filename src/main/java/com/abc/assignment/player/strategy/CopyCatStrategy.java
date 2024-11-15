package com.abc.assignment.player.strategy;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;

public class CopyCatStrategy implements Strategy {

    @Override
    public Hand getHand(Result lastResult, Hand lastPlayed) {
        if (lastPlayed == null) {
            return Hand.random();
        }

        return switch (lastResult) {
            case DRAW -> lastPlayed;
            case WIN  -> lastPlayed.getBeats();
            case LOSE -> lastPlayed.getLosesTo();
        };
    }
}
