package com.rock.paper.scissors.game.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class GameResult {
    private final GameState gameState;
    private final String lostPlayer;
    private final String wonPlayer;
    private final List<String> drawPlayers;
}
