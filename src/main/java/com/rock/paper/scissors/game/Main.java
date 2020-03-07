package com.rock.paper.scissors.game;

import com.rock.paper.scissors.game.service.impl.game.GameResultProcessorService;
import com.rock.paper.scissors.game.service.impl.game.GameService;
import com.rock.paper.scissors.game.service.impl.game.SimulationRunnerService;
import com.rock.paper.scissors.game.service.impl.player.simulator.DetermenisticPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.player.simulator.RandomPlayerActionSimulator;
import com.rock.paper.scissors.game.service.impl.random.generators.FixedRangeRandomValueGenerator;
import com.rock.paper.scissors.game.service.impl.random.generators.OnlyOneValueProvider;

public class Main {
    public static void main(String[] args) {
        var simulation = SimulationRunnerService.builder()
                .game(new GameService(new GameResultProcessorService()))
                .firstActionSimulator(DetermenisticPlayerActionSimulator.of("1", new OnlyOneValueProvider()))
                .secondActionSimulator(RandomPlayerActionSimulator.of("2", new FixedRangeRandomValueGenerator()))
                .numberOfTrials(100)
                .build();
        simulation.run();
        simulation.output(System.out);
    }
}
