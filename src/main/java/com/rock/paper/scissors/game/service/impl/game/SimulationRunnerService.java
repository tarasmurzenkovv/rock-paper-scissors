package com.rock.paper.scissors.game.service.impl.game;

import com.rock.paper.scissors.game.service.Game;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import com.rock.paper.scissors.game.service.SimulationRunner;
import lombok.Builder;
import lombok.SneakyThrows;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Builder
public class SimulationRunnerService implements SimulationRunner {
    private final int numberOfTrials;
    private final Game game;
    private final PlayerActionSimulator firstActionSimulator;
    private final PlayerActionSimulator secondActionSimulator;
    private final OutputStream outputStream;
    private String results;

    @Override
    public synchronized void run() {
        results = IntStream.range(0, numberOfTrials)
                .mapToObj(trial -> game.execute(firstActionSimulator, secondActionSimulator))
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    @SneakyThrows
    public void output(OutputStream outputStream) {
        try(var bufferedOutPutStream = new BufferedOutputStream(outputStream)) {
            bufferedOutPutStream.write(results.getBytes());
        }
    }
}
