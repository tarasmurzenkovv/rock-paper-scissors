package com.rock.paper.scissors.game.service.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.NonRandomPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.NonRandomActionGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonRandomPlayerActionSimulatorTest {
    private static final String PLAYER_NAME = "Player 1";
    private final PlayerActionSimulator sut = NonRandomPlayerActionSimulator.of(PLAYER_NAME, new NonRandomActionGenerator());

    @Test
    public void shouldReturnRockActionForNonRandomActionGenerator() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isEqualTo(PlayerAction.ROCK);
    }

    @Test
    public void shouldGetPlayerName() {
        Assertions.assertThat(sut.name())
                .isNotNull()
                .isNotBlank()
                .isEqualTo(PLAYER_NAME);
    }
}
