package com.rock.paper.scissors.game.service.game;

import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.service.Game;
import com.rock.paper.scissors.game.service.impl.player.simulator.DetermenisticPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.RandomPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.FixedRangeRandomValueGenerator;
import com.rock.paper.scissors.game.service.impl.random.generators.OnlyOneValueProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class GameServiceTest {
    private final Game game = new GameService(new GameResultProcessorService());
    private final OnlyOneValueProvider actionGenerator = new OnlyOneValueProvider();
    private final FixedRangeRandomValueGenerator fixedRangeRandomValueGenerator = Mockito.mock(FixedRangeRandomValueGenerator.class);
    private final DetermenisticPlayerActionSimulator firstPlayer = DetermenisticPlayerActionSimulator.of("1", actionGenerator);
    private final RandomPlayerActionSimulator secondPlayer = RandomPlayerActionSimulator.of("2", fixedRangeRandomValueGenerator);

    @Test
    public void whenBothPlayersReturnTheSameThenThisIsDraw() {
        Mockito.when(fixedRangeRandomValueGenerator.get()).thenReturn(1);
        Assertions.assertThat(game.execute(firstPlayer, secondPlayer))
                .isNotNull()
                .hasFieldOrPropertyWithValue("gameState", GameState.DRAW)
                .hasFieldOrPropertyWithValue("lostPlayer", null)
                .hasFieldOrPropertyWithValue("wonPlayer", null)
                .hasFieldOrPropertyWithValue("drawPlayers", List.of("2", "1"));
    }

    @Test
    public void whenOnePlayerReturnsRockAndTheSecondPlayerScissorThenThisIsWinForSecondPlayer() {
        Mockito.when(fixedRangeRandomValueGenerator.get()).thenReturn(2);
        Assertions.assertThat(game.execute(firstPlayer, secondPlayer))
                .isNotNull()
                .hasFieldOrPropertyWithValue("gameState", GameState.LOOSE)
                .hasFieldOrPropertyWithValue("lostPlayer", "1")
                .hasFieldOrPropertyWithValue("wonPlayer", "2")
                .hasFieldOrPropertyWithValue("drawPlayers", null);
    }

    @Test
    public void whenOnePlayerReturnsRockAndTheSecondPlayerScissorThenThisIsWinForFirstPlayer() {
        Mockito.when(fixedRangeRandomValueGenerator.get()).thenReturn(3);
        Assertions.assertThat(game.execute(firstPlayer, secondPlayer))
                .isNotNull()
                .hasFieldOrPropertyWithValue("gameState", GameState.WIN)
                .hasFieldOrPropertyWithValue("lostPlayer", "2")
                .hasFieldOrPropertyWithValue("wonPlayer", "1")
                .hasFieldOrPropertyWithValue("drawPlayers", null);
    }
}
