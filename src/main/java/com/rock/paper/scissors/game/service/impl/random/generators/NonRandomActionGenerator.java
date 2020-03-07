package com.rock.paper.scissors.game.service.impl.random.generators;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.ActionGenerator;

public class NonRandomActionGenerator implements ActionGenerator {
    @Override
    public PlayerAction generate() {
        return PlayerAction.ROCK;
    }
}
