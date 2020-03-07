package com.rock.paper.scissors.game.service.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.NonRandomPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.NonRandomActionGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonRandomPlayerActionSimulatorTest {
    PlayerActionSimulator sut = new NonRandomPlayerActionSimulator("Player 1", new NonRandomActionGenerator());

    @Test
    public void shouldReturnRockActionForNonRandomActionGenerator() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isEqualTo(PlayerAction.ROCK);
    }

    @Test
    public void shouldGetPlayerName() {
        Assertions.assertThat(sut.name()).isNotNull().isEqualTo("Player 1");
    }
}
