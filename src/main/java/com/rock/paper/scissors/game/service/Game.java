package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.GameState;

public interface Game {
    GameState execute(PlayerActionSimulator firstPlayer,
                      PlayerActionSimulator secondPlayer);
}
