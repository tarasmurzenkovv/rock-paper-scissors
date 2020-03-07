package com.rock.paper.scissors.game.service.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.RandomPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.FixedRangeRandomValueGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

public class RandomPlayerActionSimulatorTest {
    private static final String PLAYER_NAME = "Random";
    private final FixedRangeRandomValueGenerator mockedRandomGenerator = Mockito.mock(FixedRangeRandomValueGenerator.class);
    private final PlayerActionSimulator sut = RandomPlayerActionSimulator.of(PLAYER_NAME, mockedRandomGenerator);

    @ParameterizedTest
    @MethodSource("valueProvider")
    public void shouldGenerateActionRockWhenRandomReturnsOne(int ordinalNumber, PlayerAction expected) {
        Mockito.when(mockedRandomGenerator.get()).thenReturn(ordinalNumber);
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isEqualTo(expected);
    }

    private static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of(1, PlayerAction.ROCK),
                Arguments.of(2, PlayerAction.PAPER),
                Arguments.of(3, PlayerAction.SCISSORS)
        );
    }
}
