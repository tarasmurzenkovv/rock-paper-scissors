package com.rock.paper.scissors.game.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PlayerActionTest {
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void shouldProperlyCreateEnum(int ordinalNumber, PlayerAction expectedValue) {
        Assertions.assertThat(PlayerAction.from(ordinalNumber))
                .isEqualTo(expectedValue);
    }

    @Test
    public void shouldThrowExceptionWhenNonExpectedOrdinalValueIsPassed() {
        Assertions.assertThatThrownBy(() -> PlayerAction.from(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot find player action by ordinal number '4'");
    }

    private static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of(1, PlayerAction.ROCK),
                Arguments.of(2, PlayerAction.PAPER),
                Arguments.of(3, PlayerAction.SCISSORS)
        );
    }
}
