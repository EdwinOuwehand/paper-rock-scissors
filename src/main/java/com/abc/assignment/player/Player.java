package com.abc.assignment.player;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;

public interface Player {

    String getName();

    Hand getHand();

    default void notify(Result result) {}
}
