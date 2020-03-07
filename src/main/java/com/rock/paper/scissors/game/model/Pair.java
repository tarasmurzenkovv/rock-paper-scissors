package com.rock.paper.scissors.game.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class Pair<L, R> {
    private final L left;
    private final R right;
}
