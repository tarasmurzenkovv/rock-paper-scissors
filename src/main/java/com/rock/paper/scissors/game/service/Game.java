package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.GameResult;
import com.rock.paper.scissors.game.model.GameState;

public interface Game {
    GameResult execute(PlayerActionSimulator firstPlayer,
                       PlayerActionSimulator secondPlayer);
}
