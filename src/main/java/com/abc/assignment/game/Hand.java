package com.abc.assignment.game;

import java.util.Random;

import static com.abc.assignment.game.Result.DRAW;
import static com.abc.assignment.game.Result.LOSE;
import static com.abc.assignment.game.Result.WIN;

public enum Hand {
    ROCK, SCISSORS, PAPER;

    private Hand beats;
    private Hand losesTo;
    private static final Random RANDOM = new Random();

    static {
        ROCK.beats          = SCISSORS;
        ROCK.losesTo        = PAPER;

        SCISSORS.beats      = PAPER;
        SCISSORS.losesTo    = ROCK;

        PAPER.beats         = ROCK;
        PAPER.losesTo       = SCISSORS;
    }

    public Result compete(Hand other) {
        if (this == other) {
            return DRAW;
        } else if (this.beats == other) {
            return WIN;
        } else {
            return LOSE;
        }
    }

    public Hand getBeats() {
        return beats;
    }

    public Hand getLosesTo() {
        return losesTo;
    }

    public static Hand random() {
        Hand[] hands = Hand.values();
        return hands[RANDOM.nextInt(hands.length)];
    }
}
