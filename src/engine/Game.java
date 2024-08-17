package engine;
import java.util.List;

import engine.piles.*;
import engine.managers.GameMediator;
import engine.managers.interfaces.*;
import engine.players.Player;

public abstract class Game {
    private final List<Player> players;
    private final Deck gameDeck;
    protected boolean gameOver = false;
    private final DiscardPile discardPile;
    private final GameMediator gameMediator;
    private int noValidCardPenalty = 1;

    private CardManager cardManager;
    private TurnManager turnManager;
    private StateManager stateManager;
    private PlayerInputManager playerInputManager;

    protected Game(List<Player> players){
        this.players = players;
        this.gameDeck = Deck.getInstance();
        this.discardPile = DiscardPile.getInstance();
        this.gameMediator = GameMediator.getInstance(this);
    }

    public CardManager getCardManager() {
        return cardManager;
    }

    public void setCardManager(CardManager cardManager) {
        this.cardManager = cardManager;
    }

    public TurnManager getTurnManager() {
        return turnManager;
    }

    public void setTurnManager(TurnManager standardTurnManager) {
        this.turnManager = standardTurnManager;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public PlayerInputManager getPlayerInputManager() {
        return playerInputManager;
    }

    public void setPlayerInputManager(PlayerInputManager standardPlayerInputManager) {
        this.playerInputManager = standardPlayerInputManager;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public int getNumberOfPlayers(){
        return players.size();
    }

    public Deck getGameDeck(){
        return gameDeck;
    }

    public DiscardPile getDiscardPile(){
        return discardPile;
    }

    public GameMediator getGameMediator(){
        return gameMediator;
    }

    public void endGame(){
        gameOver = true;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public int getNoValidCardPenalty(){
        return noValidCardPenalty;
    }

    protected void setNoValidCardPenalty(int noValidCardPenalty){
        this.noValidCardPenalty = noValidCardPenalty;
    }

    protected abstract void initDeck();
    protected abstract void play();
    public abstract boolean winingCondition(Player player);

}
