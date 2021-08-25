package com.game.rockpaperscissor.utility;

import static com.game.rockpaperscissor.utility.ResultOptions.*;

public class EvaluateWinner {
    private PlayerActionService playerOneAction;

    private PlayerActionService playerTwoAction;

    private ResultOptions resultOptions;

    public EvaluateWinner(PlayerActionService playerOneMove, PlayerActionService playerTwoMove) {
        this.playerOneAction = playerOneMove;
        this.playerTwoAction = playerTwoMove;
        this.resultOptions = evaluateWinner();
    }

    /**
     * @return results of the winner
     */
    private ResultOptions evaluateWinner() {

        ResultOptions resultOptions = DRAW;
        if (playerOneAction.canWinOver(playerTwoAction)) {
            resultOptions = WIN;
        } else if (playerTwoAction.canWinOver(playerOneAction)) {
            resultOptions = LOSE;
        }

        return resultOptions;
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

    public ResultOptions getActionResult() {
        return resultOptions;
    }

    public void setActionResult(ResultOptions resultOptions) {
        this.resultOptions = resultOptions;
    }


}
