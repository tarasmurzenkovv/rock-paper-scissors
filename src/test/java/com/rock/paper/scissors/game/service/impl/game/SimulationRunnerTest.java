package com.rock.paper.scissors.game.service.impl.game;

import com.rock.paper.scissors.game.model.GameResult;
import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.service.Game;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.SimulationRunner;
import com.rock.paper.scissors.game.service.impl.player.simulator.DetermenisticPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.RandomPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.FixedRangeRandomValueGenerator;
import com.rock.paper.scissors.game.service.impl.random.generators.OnlyOneValueProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SimulationRunnerTest {
    private Game game = Mockito.mock(GameService.class);
    private SimulationRunner sut = SimulationRunnerService.builder().game(game)
            .firstActionSimulator(DetermenisticPlayerActionSimulator.of("1", new OnlyOneValueProvider()))
            .secondActionSimulator(RandomPlayerActionSimulator.of("2", new FixedRangeRandomValueGenerator()))
            .numberOfTrials(2)
            .outputStream(System.out)
            .build();

    @Test
    public void shouldRunSpecfiedNumberOfTimesGameSimulation() {
        Mockito.when(game.execute(Mockito.any(PlayerActionSimulator.class), Mockito.any(PlayerActionSimulator.class)))
                .thenReturn(GameResult.of(GameState.WIN, "1", "2"));
        sut.run();
        Mockito.verify(game, Mockito.times(2)).execute(Mockito.any(), Mockito.any());
    }
}
