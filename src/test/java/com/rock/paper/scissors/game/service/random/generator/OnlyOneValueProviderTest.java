package com.rock.paper.scissors.game.service.random.generator;

import com.rock.paper.scissors.game.service.impl.random.generators.OnlyOneValueProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class OnlyOneValueProviderTest {
    private final Supplier<Integer> sut = new OnlyOneValueProvider();

    @Test
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.get())
                .isNotNull()
                .isEqualTo(1);
    }
}
