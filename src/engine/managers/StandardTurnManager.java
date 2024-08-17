package engine.managers;

import engine.managers.interfaces.TurnManager;
import engine.players.Player;

import java.util.List;

public class StandardTurnManager implements TurnManager {
    private static StandardTurnManager standardTurnManager;
    private boolean clockWiseDirection;
    private final List<Player> players;
    private int currentPlayerIndex;

    private StandardTurnManager(List<Player> players){
        this.players = players;
        clockWiseDirection = true;
        currentPlayerIndex = 0;
    }

    public static StandardTurnManager getInstance(List<Player> players){
        if(standardTurnManager == null){
            standardTurnManager = new StandardTurnManager(players);
        }
        return standardTurnManager;
    }

    @Override
    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    @Override
    public Player getNextPlayer(){
        if(clockWiseDirection){
            return players.get((currentPlayerIndex + 1) % players.size());
        }
        return players.get(currentPlayerIndex == 0 ? players.size() - 1 : currentPlayerIndex - 1);
    }

    @Override
    public Player getLastPlayer(){
        if(clockWiseDirection){
            return players.get((currentPlayerIndex == 0 ? players.size() - 1 : currentPlayerIndex - 1));
        }
        return players.get((currentPlayerIndex == players.size() ? 0 : currentPlayerIndex + 1));
    }

    @Override
    public void reverseGameDirection() {
        clockWiseDirection = !clockWiseDirection;
    }

    @Override
    public void moveToNextPlayer(){
        if(clockWiseDirection){
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        else{
            currentPlayerIndex = (currentPlayerIndex == 0 ? players.size() - 1 : currentPlayerIndex - 1);
        }
    }


}
