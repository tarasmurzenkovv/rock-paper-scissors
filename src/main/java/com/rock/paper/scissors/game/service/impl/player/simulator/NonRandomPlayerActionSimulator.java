package com.rock.paper.scissors.game.service.impl.player.simulator;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;

public class NonRandomPlayerActionSimulator implements PlayerActionSimulator {
    @Override
    public PlayerAction generate() {
        return PlayerAction.ROCK;
    }
}
