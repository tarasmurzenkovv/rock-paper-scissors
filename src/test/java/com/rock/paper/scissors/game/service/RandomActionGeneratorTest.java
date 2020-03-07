package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.impl.RandomActionGenerator;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;

public class RandomActionGeneratorTest {
    private final ActionGenerator sut = new RandomActionGenerator();

    @RepeatedTest(1000)
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isIn(Arrays.asList(PlayerAction.values()));
    }
}
