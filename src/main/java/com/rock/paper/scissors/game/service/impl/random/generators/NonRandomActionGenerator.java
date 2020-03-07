package com.rock.paper.scissors.game.service.impl.random.generators;

import com.rock.paper.scissors.game.model.PlayerAction;

import java.util.function.Supplier;

public class NonRandomActionGenerator implements Supplier<PlayerAction> {
    @Override
    public PlayerAction get() {
        return PlayerAction.ROCK;
    }
}
