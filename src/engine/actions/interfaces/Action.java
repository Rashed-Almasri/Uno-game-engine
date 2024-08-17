package engine.actions.interfaces;

import engine.Game;
import engine.players.Player;
import enums.CardAction;

public interface Action {
    public void executeAction(Game game, Player player);
}
