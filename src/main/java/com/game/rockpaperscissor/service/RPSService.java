package com.game.rockpaperscissor.service;

import com.game.rockpaperscissor.model.Result;
import com.game.rockpaperscissor.utility.EvaluateWinner;
import com.game.rockpaperscissor.utility.PlayerActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RPSService {

    @Autowired
    RandomActionGeneratorService randomActionGeneratorService;

    /**
     * This method generate result based on both player's action
     *
     * @param playerOneAction
     * @return Result object as REST API response
     */
    public Result playGame(PlayerActionService playerOneAction) {
        PlayerActionService PlayerTwoAction = randomActionGeneratorService.getRandomAction();

        EvaluateWinner evaluateWinner = new EvaluateWinner(playerOneAction, PlayerTwoAction);
        evaluateWinner.getActionResult();
        Result result = new Result(playerOneAction, PlayerTwoAction, evaluateWinner.getActionResult());
        return result;
    }

}
