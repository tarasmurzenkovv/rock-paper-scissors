package com.rock.paper.scissors.game.service.impl.random.generators;

import com.rock.paper.scissors.game.model.PlayerAction;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomActionGenerator implements Supplier<PlayerAction> {
    private static final int LOW_BOUND = 1;
    private static final int UPPER_BOUND = 4;

    @Override
    public PlayerAction get() {
        var ordinalNumberOfPlayerAction = ThreadLocalRandom.current().nextInt(LOW_BOUND, UPPER_BOUND);
        return PlayerAction.from(ordinalNumberOfPlayerAction);
    }
}
