package engine.managers;

import engine.Game;
import engine.managers.interfaces.StateManager;
import engine.players.Player;

public class StandardStateManager implements StateManager {
    private static StandardStateManager standardStateManager;
    private final Game game;

    private StandardStateManager(Game game) {
        this.game = game;
    }

    public static StandardStateManager getInstance(Game game) {
        if (standardStateManager == null) {
            standardStateManager = new StandardStateManager(game);
        }
        return standardStateManager;
    }

    private void changeGameStatus(Player player){
        game.getPlayers().remove(player);
        game.getGameMediator().setNumberOfRemainingPlayers(
                game.getGameMediator().getNumberOfRemainingPlayers() - 1
        );

        System.out.println("Player : " + player.getName() + " has finished, the game will continue with the remaining players");
    }

    private void endGame(){
        game.endGame();
    }

    private void checkGameStatus(){
        if(game.getGameMediator().getNumberOfRemainingPlayers() == 1){
            endGame();
        }
    }

    @Override
    public boolean hasWon(Player player) {
        if(!game.winingCondition(player)){
            return false;
        }

        changeGameStatus(player);
        checkGameStatus();

        return true;
    }
}
