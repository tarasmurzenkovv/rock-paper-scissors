package com.rock.paper.scissors.game.service.impl.game;

import com.rock.paper.scissors.game.model.GameResult;
import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.service.Game;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.SimulationRunner;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SimulationRunnerTest {
    private Game game = Mockito.mock(GameService.class);
    private SimulationRunner sut = new SimulationRunnerService();

    @Test
    public void shouldRunSpecfiedNumberOfTimesGameSimulation(){
        Mockito.when(game.execute(Mockito.any(PlayerActionSimulator.class), Mockito.any(PlayerActionSimulator.class)))
                .thenReturn(GameResult.of(GameState.WIN, "1", "2"));
    }
}
