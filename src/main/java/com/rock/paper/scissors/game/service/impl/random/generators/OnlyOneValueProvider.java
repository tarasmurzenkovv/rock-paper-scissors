package com.rock.paper.scissors.game.service.impl.random.generators;

import java.util.function.Supplier;

public class OnlyOneValueProvider implements Supplier<Integer> {
    @Override
    public Integer get() {
        return 1;
    }
}
