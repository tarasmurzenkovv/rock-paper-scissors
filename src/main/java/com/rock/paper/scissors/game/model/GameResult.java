package com.rock.paper.scissors.game.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
public class GameResult {
    private final GameState gameState;
    private final String lostPlayer;
    private final String wonPlayer;
    private final List<String> drawPlayers;

    public static GameResult of(GameState gameState, List<String> drawPlayers) {
        return GameResult.of(gameState, null, null, drawPlayers);
    }

    public static GameResult of(GameState gameState, String firstName, String secondName) {
        return GameResult.of(gameState, firstName, secondName, null);
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "gameState=" + gameState +
                ", lostPlayer='" + lostPlayer + '\'' +
                ", wonPlayer='" + wonPlayer + '\'' +
                ", drawPlayers=" + drawPlayers +
                '}';
    }
}
