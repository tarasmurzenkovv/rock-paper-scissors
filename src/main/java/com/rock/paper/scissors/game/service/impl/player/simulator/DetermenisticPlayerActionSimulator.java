package com.rock.paper.scissors.game.service.impl.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor(staticName = "of")
public class DetermenisticPlayerActionSimulator implements PlayerActionSimulator {
    private final String playerName;
    private final Supplier<Integer> actionGenerator;

    @Override
    public PlayerAction generate() {
        return PlayerAction.from(actionGenerator.get());
    }

    @Override
    public String name() {
        return playerName;
    }
}
