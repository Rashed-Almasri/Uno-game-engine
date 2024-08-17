package engine.actions;

import engine.Game;
import engine.actions.interfaces.Action;
import engine.players.Player;
import enums.CardAction;

public class DrawFour implements Action {

    @Override
    public void executeAction(Game game, Player player) {
        new ChangeColor().executeAction(game, player);
        game.getCardManager().drawCards(player, 4);
        new Skip().executeAction(game, player);
    }
}
