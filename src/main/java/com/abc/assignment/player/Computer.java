package com.abc.assignment.player;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;
import com.abc.assignment.player.strategy.RockSolidStrategy;
import com.abc.assignment.player.strategy.WinningStrategy;
import com.abc.assignment.player.strategy.CopyCatStrategy;
import com.abc.assignment.player.strategy.RandomStrategy;
import com.abc.assignment.player.strategy.Strategy;

import java.util.Random;

public class Computer implements Player {

    private final Strategy strategy;

    private Hand lastPlayed;
    private Result lastResult;

    public Computer() {
        Strategy[] strategies = {
            new RockSolidStrategy(),
            new RandomStrategy(),
            new WinningStrategy(),
            new CopyCatStrategy()
        };
        this.strategy = strategies[new Random().nextInt(strategies.length)];
    }

    @Override
    public Hand getHand() {
        Hand hand = strategy.getHand(lastResult, lastPlayed);
        lastPlayed = hand;
        return hand;
    }

    @Override
    public void notify(Result result) {
        this.lastResult = result;
    }

    @Override
    public String getName() {
        return "RPS Bot";
    }
}
