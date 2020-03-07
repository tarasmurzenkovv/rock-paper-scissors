package com.rock.paper.scissors.game.service.impl.random.generators;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.ActionGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomActionGenerator implements ActionGenerator {

    @Override
    public PlayerAction generate() {
        int ordinalNumberOfPlayerAction = ThreadLocalRandom.current().nextInt(1, 4);
        return PlayerAction.from(ordinalNumberOfPlayerAction);
    }
}
