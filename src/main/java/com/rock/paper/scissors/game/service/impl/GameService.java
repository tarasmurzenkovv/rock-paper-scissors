package com.rock.paper.scissors.game.service.impl;

import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.Game;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;

public class GameService implements Game {
    @Override
    public GameState execute(PlayerActionSimulator firstPlayer, PlayerActionSimulator secondPlayer) {
        var actionOfFirstPlayer = firstPlayer.generate();
        var actionOfSecondPlayer = secondPlayer.generate();
        if (actionOfFirstPlayer == actionOfSecondPlayer) {
            return GameState.DRAW;
        } else if (actionOfSecondPlayer == PlayerAction.SCISSORS) {
            return GameState.WIN;
        }
        return null;
    }
}
