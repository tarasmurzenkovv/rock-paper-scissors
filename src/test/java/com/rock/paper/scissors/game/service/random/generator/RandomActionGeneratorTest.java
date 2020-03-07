package com.rock.paper.scissors.game.service.random.generator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.impl.random.generators.RandomActionGenerator;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.function.Supplier;

public class RandomActionGeneratorTest {
    private final Supplier<PlayerAction> sut = new RandomActionGenerator();

    @RepeatedTest(1000)
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.get())
                .isNotNull()
                .isIn(Arrays.asList(PlayerAction.values()));
    }
}
