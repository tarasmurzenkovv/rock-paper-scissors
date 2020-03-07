package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.impl.NonRandomActionGenerator;
import com.rock.paper.scissors.game.service.impl.RandomActionGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RandomActionGeneratorTest {
    private final ActionGenerator sut = new RandomActionGenerator();

    @Test
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isEqualTo(PlayerAction.ROCK);
    }
}
