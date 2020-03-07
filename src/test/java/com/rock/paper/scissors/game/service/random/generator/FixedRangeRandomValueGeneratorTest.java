package com.rock.paper.scissors.game.service.random.generator;

import com.rock.paper.scissors.game.service.impl.random.generators.FixedRangeRandomValueGenerator;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.RepeatedTest;

import java.util.function.Supplier;

public class FixedRangeRandomValueGeneratorTest {
    private final Supplier<Integer> sut = new FixedRangeRandomValueGenerator();

    @RepeatedTest(1000)
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.get())
                .isNotNull()
                .isIn(1, 2, 3);
    }
}
