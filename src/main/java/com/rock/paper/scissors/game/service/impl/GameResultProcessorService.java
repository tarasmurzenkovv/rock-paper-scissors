package com.rock.paper.scissors.game.service.impl;

import com.rock.paper.scissors.game.model.GameResult;
import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.service.GameResultProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class GameResultProcessorService implements GameResultProcessor {
    private static final Map<GameState, BiFunction<String, String, GameResult>> STRATEGY = GameResultProcessorService.build();

    @Override
    public GameResult process(GameState gameState, String lostPlayer, String wonPlayer) {
        return STRATEGY.get(gameState).apply(lostPlayer, wonPlayer);
    }

    private static Map<GameState, BiFunction<String, String, GameResult>> build() {
        var strategy = new HashMap<GameState, BiFunction<String, String, GameResult>>();
        strategy.put(GameState.WIN, (lostPlayer, wonPlayer) -> GameResult.of(GameState.WIN, lostPlayer, wonPlayer));
        strategy.put(GameState.DRAW, (lostPlayer, wonPlayer) -> GameResult.of(GameState.DRAW, List.of(lostPlayer, wonPlayer)));
        strategy.put(GameState.LOOSE, (lostPlayer, wonPlayer) -> GameResult.of(GameState.LOOSE, wonPlayer, lostPlayer));
        return strategy;
    }

}
