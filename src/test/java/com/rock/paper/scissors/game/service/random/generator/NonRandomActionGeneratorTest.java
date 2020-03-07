package com.rock.paper.scissors.game.service.random.generator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.ActionGenerator;
import com.rock.paper.scissors.game.service.impl.random.generators.NonRandomActionGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonRandomActionGeneratorTest {
    private final ActionGenerator sut = new NonRandomActionGenerator();

    @Test
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isEqualTo(PlayerAction.ROCK);
    }
}
