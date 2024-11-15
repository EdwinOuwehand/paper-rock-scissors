package com.abc.assignment.game;

import com.abc.assignment.player.Player;

import static com.abc.assignment.game.Result.WIN;

public class Game {

    private final Player p1;
    private final Player p2;

    private int nrOfRounds;

    private int scoreP1 = 0;
    private int scoreP2 = 0;

    public Game(Player p1, Player p2, int nrOfRounds) {
        this.p1 = p1;
        this.p2 = p2;
        this.nrOfRounds = nrOfRounds;
    }

    public void play() {
        while (nrOfRounds > 0) {
            playRound();
            nrOfRounds--;

            if (Math.abs(scoreP1 - scoreP2) > nrOfRounds) { // Not technically in the requirements
                break;
            }
        }

        printResult();
    }

    private void playRound() {
        Hand h1 = p1.getHand();
        Hand h2 = p2.getHand();

        System.out.printf("%s: %s, %s: %s\n", p1.getName(), h1, p2.getName(), h2);

        Result p1Result = h1.compete(h2);
        Result p2Result = h2.compete(h1);

        if (p1Result == WIN)
            scoreP1++;

        if (p2Result == WIN)
            scoreP2++;

        p1.notify(p1Result);
        p2.notify(p2Result);
    }

    private void printResult() {
        if (scoreP1 == scoreP2) {
            System.out.println("\nGame complete. It's a draw. Final score: %d - %d".formatted(scoreP1, scoreP2));
        } else {
            String winner = scoreP1 > scoreP2 ? p1.getName() : p2.getName();
            System.out.println("\nGame complete. %s wins. Final score: %d - %d".formatted(winner, scoreP1, scoreP2));
        }
    }
}
