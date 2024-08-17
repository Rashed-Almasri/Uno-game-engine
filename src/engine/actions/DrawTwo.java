package engine.actions;

import engine.Game;
import engine.actions.interfaces.Action;
import engine.players.Player;
import enums.CardAction;

public class DrawTwo implements Action {


    @Override
    public void executeAction(Game game, Player player) {
        game.getCardManager().drawCards(player, 2);
        new Skip().executeAction(game, player);
    }
}
