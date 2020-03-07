package com.rock.paper.scissors.game.service.impl.game;

import com.rock.paper.scissors.game.model.GameResult;
import com.rock.paper.scissors.game.model.GameState;
import com.rock.paper.scissors.game.model.Pair;
import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.Game;
import com.rock.paper.scissors.game.service.GameResultProcessor;
import com.rock.paper.scissors.game.service.PlayerActionSimulator;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class GameService implements Game {
    private static final Map<Pair<PlayerAction, PlayerAction>, GameState> STRATEGY = GameService.build();
    private final GameResultProcessor gameResultProcessor;

    @Override
    public GameResult execute(PlayerActionSimulator firstPlayer, PlayerActionSimulator secondPlayer) {
        var actionOfFirstPlayer = firstPlayer.generate();
        var actionOfSecondPlayer = secondPlayer.generate();
        var gameState = STRATEGY.get(Pair.of(actionOfFirstPlayer, actionOfSecondPlayer));
        return gameResultProcessor.process(gameState, secondPlayer.name(), firstPlayer.name());
    }

    private static Map<Pair<PlayerAction, PlayerAction>, GameState> build() {
        var strategy = new HashMap<Pair<PlayerAction, PlayerAction>, GameState>();
        strategy.put(Pair.of(PlayerAction.ROCK, PlayerAction.ROCK), GameState.DRAW);
        strategy.put(Pair.of(PlayerAction.PAPER, PlayerAction.PAPER), GameState.DRAW);
        strategy.put(Pair.of(PlayerAction.SCISSORS, PlayerAction.SCISSORS), GameState.DRAW);
        strategy.put(Pair.of(PlayerAction.ROCK, PlayerAction.SCISSORS), GameState.WIN);
        strategy.put(Pair.of(PlayerAction.ROCK, PlayerAction.PAPER), GameState.LOOSE);
        strategy.put(Pair.of(PlayerAction.SCISSORS, PlayerAction.PAPER), GameState.WIN);
        strategy.put(Pair.of(PlayerAction.SCISSORS, PlayerAction.ROCK), GameState.LOOSE);
        strategy.put(Pair.of(PlayerAction.PAPER, PlayerAction.ROCK), GameState.WIN);
        strategy.put(Pair.of(PlayerAction.PAPER, PlayerAction.SCISSORS), GameState.LOOSE);
        return strategy;
    }
}
