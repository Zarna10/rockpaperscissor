package com.game.rockpaperscissor.model;

import com.game.rockpaperscissor.utility.PlayerActionService;
import com.game.rockpaperscissor.utility.ResultOptions;

public class Result {
    private PlayerActionService playerOneAction;
    private PlayerActionService playerTwoAction;
    private ResultOptions result;

    /**
     * @param playerOneAction action given by first player
     * @param playerTwoAction action generated randomly for second player
     * @param result win, lose or draw
     */
    public Result(PlayerActionService playerOneAction, PlayerActionService playerTwoAction, ResultOptions result) {
        this.playerOneAction = playerOneAction;
        this.playerTwoAction = playerTwoAction;
        this.result = result;
    }

    public PlayerActionService getPlayerOneAction() {
        return playerOneAction;
    }

    public void setPlayerOneAction(PlayerActionService playerOneAction) {
        this.playerOneAction = playerOneAction;
    }

    public PlayerActionService getPlayerTwoAction() {
        return playerTwoAction;
    }

    public void setPlayerTwoAction(PlayerActionService playerTwoAction) {
        this.playerTwoAction = playerTwoAction;
    }

    public ResultOptions getResult() {
        return result;
    }

    public void setResult(ResultOptions result) {
        this.result = result;
    }


}
