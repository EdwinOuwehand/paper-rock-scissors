package com.abc.assignment.player.strategy;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;

public interface Strategy {

    Hand getHand(Result lastResult, Hand lastPlayed);
}
