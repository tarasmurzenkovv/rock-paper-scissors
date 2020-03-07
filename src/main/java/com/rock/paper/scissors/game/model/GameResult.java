package com.rock.paper.scissors.game.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GameResult {
    private final GameState gameState;
    private final String lostPlayer;
    private final String wonPlayer;
}
