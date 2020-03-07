package com.rock.paper.scissors.game.service;

import com.rock.paper.scissors.game.model.GameResult;
import com.rock.paper.scissors.game.model.GameState;

public interface GameResultProcessor {
    GameResult process(GameState gameState, String lostPlayer, String wonPlayer);
}
