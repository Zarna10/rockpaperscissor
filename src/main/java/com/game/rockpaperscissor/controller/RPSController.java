package com.game.rockpaperscissor.controller;

import com.game.rockpaperscissor.exception.ActionNotFoundException;
import com.game.rockpaperscissor.model.Result;
import com.game.rockpaperscissor.service.RPSService;
import com.game.rockpaperscissor.utility.PlayerActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RPSController {
    @Autowired
    RPSService rpsService;

    @PostMapping("/rpsgame/{playeroneaction}")
    public Result action(@PathVariable("playeroneaction") String playeroneaction) throws ActionNotFoundException {
        boolean validAction = false;

        for (PlayerActionService playerActionService : PlayerActionService.values()) {
            if (playerActionService.name().equals(playeroneaction.toUpperCase())) {
                validAction = true;
                break;
            }
        }
        if (validAction) {
            PlayerActionService playerOneAction = PlayerActionService.valueOf(playeroneaction.toUpperCase());
            return rpsService.playGame(playerOneAction);
        } else {
            throw new ActionNotFoundException("This is NOT a valid action");
        }
    }
}
