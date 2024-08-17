package engine.actions;

import engine.Game;
import engine.actions.interfaces.Action;
import engine.players.Player;
import enums.CardAction;

public class ChangeColor implements Action {
    @Override
    public void executeAction(Game game, Player player) {
        game.getCardManager().changeGameColor(
                game.getPlayerInputManager().getColor()
        );
    }
}
