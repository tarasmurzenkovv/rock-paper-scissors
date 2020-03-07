package com.rock.paper.scissors.game.service.game;

import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.service.GameResultProcessor;
import com.rock.paper.scissors.game.service.impl.GameResultProcessorService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void shouldProperlyBuildForDrawGameState() {
        Assertions.assertThat(sut.process(GameState.DRAW, "1", "2"))
                .isNotNull()
                .hasFieldOrPropertyWithValue("gameState", GameState.DRAW)
                .hasFieldOrPropertyWithValue("lostPlayer", null)
                .hasFieldOrPropertyWithValue("wonPlayer", null)
                .hasFieldOrPropertyWithValue("drawPlayers", List.of("1", "2"));
    }

    @Test
    public void shouldProperlyBuildForLooseGameState() {
        Assertions.assertThat(sut.process(GameState.LOOSE, "1", "2"))
                .isNotNull()
                .hasFieldOrPropertyWithValue("gameState", GameState.LOOSE)
                .hasFieldOrPropertyWithValue("lostPlayer", "1")
                .hasFieldOrPropertyWithValue("wonPlayer", "2")
                .hasFieldOrPropertyWithValue("drawPlayers", null);
    }
}
