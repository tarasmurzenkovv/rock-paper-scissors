package com.rock.paper.scissors.game.service.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.FixedRangeRandomValueGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RandomPlayerActionSimulatorTest {
    private final PlayerActionSimulator sut = RandomPlayerActionSimulator.of(PLAYER_NAME, new FixedRangeRandomValueGenerator());

    @RepeatedTest(1000)
    public void shouldGenerateActionOnlyFromGivenRange() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isIn(PlayerAction.ROCK, PlayerAction.PAPER, PlayerAction.SCISSORS);
    }
}
