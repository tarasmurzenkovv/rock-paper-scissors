package com.rock.paper.scissors.game.service.random.generator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.impl.random.generators.NonRandomActionGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class NonRandomActionGeneratorTest {
    private final Supplier<PlayerAction> sut = new NonRandomActionGenerator();

    @Test
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.get())
                .isNotNull()
                .isEqualTo(PlayerAction.ROCK);
    }
}
