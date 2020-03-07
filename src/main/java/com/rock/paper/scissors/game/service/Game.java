package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.GameResult;

public interface Game {
    GameResult execute(PlayerActionSimulator firstPlayer,
                       PlayerActionSimulator secondPlayer);
}
