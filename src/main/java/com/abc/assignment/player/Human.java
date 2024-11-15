package com.abc.assignment.player;

import com.abc.assignment.game.Hand;
import com.abc.assignment.game.Result;

import java.util.Scanner;

public class Human implements Player {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Hand getHand() {
        Hand hand = null;
        while (hand == null) {
            System.out.print("Enter your choice (rock, paper, scissors): ");
            String input = scanner.nextLine();
            try {
                hand = Hand.valueOf(input.trim().toUpperCase());
            } catch (IllegalArgumentException ignored) {
                System.out.println("Invalid input");
            }
        }
        return hand;
    }

    @Override
    public void notify(Result result) {
        System.out.printf("You %s this round\n", result.name().toLowerCase());
    }

    @Override
    public String getName() {
        return "Human";
    }
}
