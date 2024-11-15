package com.abc.assignment.player;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.abc.assignment.game.Hand.ROCK;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HumanTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @ParameterizedTest
    @EnumSource(Hand.class)
    void getHand(Hand hand) {
        String input = hand.name().toLowerCase();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(hand, new Human().getHand());
    }

    @Test
    void invalidInput() {
        String input = "invalid\nrock\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Human human = new Human();
        assertEquals(ROCK, human.getHand());
        assertTrue(outContent.toString().contains("Invalid input"));
    }

    @ParameterizedTest
    @EnumSource(Result.class)
    void notify(Result result) {
        new Human().notify(result);
        assertEquals(outContent.toString(), format("You %s this round\n", result.name().toLowerCase()));
    }

    @Test
    void getName() {
        assertEquals("Human", new Human().getName());
    }
}
