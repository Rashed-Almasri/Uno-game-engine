package engine.actions;

import engine.Game;
import engine.actions.interfaces.Action;
import engine.players.Player;
import enums.CardAction;

public class NoAction implements Action {


    @Override
    public void executeAction(Game game, Player player) {
        //no action
    }
}
