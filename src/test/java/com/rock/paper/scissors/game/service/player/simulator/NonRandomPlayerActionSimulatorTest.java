package com.rock.paper.scissors.game.service.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.NonRandomPlayerActionSimulator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonRandomPlayerActionSimulatorTest {
    PlayerActionSimulator sut = new NonRandomPlayerActionSimulator();

    @Test
    public void shouldReturnRockActionForNonRandomActionGenerator() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isEqualTo(PlayerAction.ROCK);
    }

    @Test
    public void shouldGetPlayerName() {
        Assertions.assertThat(sut.playerInformation()).isNotNull().isEqualTo("Player 1");
    }
}
