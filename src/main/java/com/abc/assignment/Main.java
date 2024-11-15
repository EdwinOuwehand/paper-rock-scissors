package com.abc.assignment;

import com.abc.assignment.game.Game;
import com.abc.assignment.player.Computer;
import com.abc.assignment.player.Human;

public final class Main {

    public static void main(String[] args) {
        int nrOfRounds = 5;
        if (args.length > 0) {
            try {
                nrOfRounds = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) { }
        }

        new Game(new Computer(), new Human(), nrOfRounds).play();
    }
}
