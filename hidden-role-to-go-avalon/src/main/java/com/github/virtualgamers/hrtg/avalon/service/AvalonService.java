package com.github.virtualgamers.hrtg.avalon.service;

import com.github.virtualgamers.hrtg.avalon.model.Avalon;

public interface AvalonService {
    void createAvalon(Avalon avalon, String username);

    void setLadyOfTheLake(Avalon avalon, String username);

    void giveCrown(Avalon avalon, String username);

    void giveTeamToken(Avalon avalon, String username);

    void removeTeamToken(Avalon avalon, String username);
}
