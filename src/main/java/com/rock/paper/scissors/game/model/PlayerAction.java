package com.rock.paper.scissors.game.model;


import java.util.Arrays;

public enum PlayerAction {
    ROCK(1), PAPER(2), SCISSORS(3);
    private final int number;

    PlayerAction(int ordinalNumber) {
        number = ordinalNumber;
    }

    public static PlayerAction from(int ordinalNumber) {
        return Arrays.stream(PlayerAction.values())
                .filter(action -> action.number == ordinalNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Cannot find player action by ordinal number '%d'", ordinalNumber)));
    }
}
