package com.game.rockpaperscissor.service;

import com.game.rockpaperscissor.utility.PlayerActionService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomActionGeneratorService {
    /**
     *
     * @return random action for second player
     */
    public PlayerActionService getRandomAction() {
        Random random = new Random();
        return PlayerActionService.values()[random.nextInt(PlayerActionService.values().length)];
    }
}
