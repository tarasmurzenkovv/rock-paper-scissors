package com.rock.paper.scissors.game.service.impl.random.generators;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomActionGenerator implements Supplier<Integer> {
    private static final int LOW_BOUND = 1;
    private static final int UPPER_BOUND = 4;

    @Override
    public Integer get() {
        return ThreadLocalRandom.current().nextInt(LOW_BOUND, UPPER_BOUND);
    }
}
