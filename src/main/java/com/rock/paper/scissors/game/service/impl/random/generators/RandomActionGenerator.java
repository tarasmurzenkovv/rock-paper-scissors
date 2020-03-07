package com.rock.paper.scissors.game.service.impl.random.generators;

import com.rock.paper.scissors.game.model.PlayerAction;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomActionGenerator implements Supplier<PlayerAction> {

    @Override
    public PlayerAction get() {
        int ordinalNumberOfPlayerAction = ThreadLocalRandom.current().nextInt(1, 4);
        return PlayerAction.from(ordinalNumberOfPlayerAction);
    }
}
