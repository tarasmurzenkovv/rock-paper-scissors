package com.rock.paper.scissors.game.service.game;

import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.service.GameResultProcessor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameResultProcessorTest {
    private final GameResultProcessor sut = new GameResultProcessorService();

    @Test
    public void shouldProperlyBuildForWinGameState() {
        Assertions.assertThat(sut.process(GameState.WIN, "1", "2"))
                .isNotNull()
                .hasFieldOrPropertyWithValue("gameState", GameState.WIN)
                .hasFieldOrPropertyWithValue("lostPlayer", "1")
                .hasFieldOrPropertyWithValue("wonPlayer", "2")
                .hasFieldOrPropertyWithValue("drawPlayers", null);
    }
}
