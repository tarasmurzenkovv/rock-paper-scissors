package com.rock.paper.scissors.game.service.impl;

import com.rock.paper.scissors.game.model.PlayerAction;
import com.rock.paper.scissors.game.service.ActionGenerator;

public class NonRandomActionGenerator implements ActionGenerator {
    @Override
    public PlayerAction generate() {
        return null;
    }
}
