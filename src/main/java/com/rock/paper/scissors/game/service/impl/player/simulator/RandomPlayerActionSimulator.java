package com.rock.paper.scissors.game.service.impl.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor(staticName = "of")
public class RandomPlayerActionSimulator implements PlayerActionSimulator {
    private final String playerName;
    private final Supplier<Integer> randomGenerator;

    @Override
    public PlayerAction generate() {
        return PlayerAction.from(randomGenerator.get());
    }

    @Override
    public String name() {
        return null;
    }
}