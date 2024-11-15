package com.abc.assignment.player;

import com.abc.assignment.game.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ComputerTest {

    @ParameterizedTest
    @NullSource
    @EnumSource(Result.class)
    void testNotify(Result result) {
        Computer computer = new Computer();
        computer.notify(result);
        assertNotNull(computer.getHand());
    }

    @Test
    void getName() {
        assertEquals("RPS Bot", new Computer().getName());
    }
}
