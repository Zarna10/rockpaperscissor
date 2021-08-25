package com.game.rockpaperscissor.utility;

import com.game.rockpaperscissor.service.ActionService;

public enum PlayerActionService implements ActionService {
    ROCK {
        @Override
        public boolean canWinOver(PlayerActionService playerAction) {
            return (SCISSOR == playerAction);
        }
    }, SCISSOR {
        @Override
        public boolean canWinOver(PlayerActionService playerAction) {
            return (PAPER == playerAction);
        }
    }, PAPER {
        @Override
        public boolean canWinOver(PlayerActionService playerAction) {
            return (ROCK == playerAction);
        }
    };
}
