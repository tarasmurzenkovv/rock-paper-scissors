package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.PlayerAction;

public interface PlayerActionSimulator {
    PlayerAction generate();

    String name();
}
