package com.game.rockpaperscissor.service;

import com.game.rockpaperscissor.utility.PlayerActionService;

public interface ActionService {
    /**
     * whether player one can win over player two
     * @param playerActionService
     * @return true or false
     */
    boolean canWinOver(PlayerActionService playerActionService);
}
