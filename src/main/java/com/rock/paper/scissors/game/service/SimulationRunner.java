package com.rock.paper.scissors.game.service;

import java.io.OutputStream;

public interface SimulationRunner {
    void run();

    void output(OutputStream outputStream);
}
