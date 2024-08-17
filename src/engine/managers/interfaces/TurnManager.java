package engine.managers.interfaces;

import engine.players.Player;

import java.util.List;

public interface TurnManager {
    Player getCurrentPlayer();
    Player getNextPlayer();
    Player getLastPlayer();
    void reverseGameDirection();
    void moveToNextPlayer();
}
