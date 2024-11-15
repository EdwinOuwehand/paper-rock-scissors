package com.abc.assignment.game;

import com.abc.assignment.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.abc.assignment.game.Hand.ROCK;
import static com.abc.assignment.game.Hand.SCISSORS;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void draw() {
        Player p1 = new MockPlayer("Player1", ROCK);
        Player p2 = new MockPlayer("Player2", ROCK);
        new Game(p1, p2, 3).play();

        assertTrue(outContent.toString().contains("Game complete. It's a draw. Final score: 0 - 0"));
    }

    @Test
    void player1Win() {
        Player p1 = new MockPlayer("Player1", ROCK);
        Player p2 = new MockPlayer("Player2", SCISSORS);
        new Game(p1, p2, 2).play();

        assertTrue(outContent.toString().contains("Game complete. Player1 wins. Final score: 2 - 0"));
    }

    @Test
    void player2Win() {
        Player p1 = new MockPlayer("Player1", SCISSORS);
        Player p2 = new MockPlayer("Player2", ROCK);
        new Game(p1, p2, 2).play();

        assertTrue(outContent.toString().contains("Game complete. Player2 wins. Final score: 0 - 2"));
    }

    @Test
    void earlyExit() {
        Player p1 = new MockPlayer("Player1", ROCK);
        Player p2 = new MockPlayer("Player2", SCISSORS);
        new Game(p1, p2, 5).play();

        assertTrue(outContent.toString().contains("Game complete. Player1 wins. Final score: 3 - 0"));
    }

    private record MockPlayer(String getName, Hand getHand) implements Player { }
}

