package com.rock.paper.scissors.game.service.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.RandomPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.FixedRangeRandomValueGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RandomPlayerActionSimulatorTest {
    private static final String PLAYER_NAME = "Random";
    private final FixedRangeRandomValueGenerator mockedRandomGenerator = Mockito.mock(FixedRangeRandomValueGenerator.class);
    private final PlayerActionSimulator sut = RandomPlayerActionSimulator.of(PLAYER_NAME, mockedRandomGenerator);

    @Test
    public void shouldGenerateActionRockWhenRandomReturnsOne() {
        Mockito.when(mockedRandomGenerator.get()).thenReturn(1);
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isIn(PlayerAction.ROCK, PlayerAction.PAPER, PlayerAction.SCISSORS);
    }
}
