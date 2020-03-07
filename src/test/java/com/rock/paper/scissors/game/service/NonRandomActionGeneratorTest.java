package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.impl.NonRandomActionGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NonRandomActionGeneratorTest {
    private ActionGenerator sut = new NonRandomActionGenerator();

    @Test
    public void shouldAlwaysReturnTheSameAction() {
        Assertions.assertThat(sut.generate())
                .isNotNull()
                .isEqualTo(PlayerAction.ROCK);
    }
}
