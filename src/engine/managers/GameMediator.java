package engine.managers;
import engine.Game;
import engine.players.Player;
import engine.cards.Card;

import java.util.List;

public class GameMediator {
    private static GameMediator gameMediator;
    private final Game game;
    private List<Player> players;
    private int numberOfRemainingPlayers;

    private GameMediator(Game game) {
        this.game = game;
        this.players = game.getPlayers();
        numberOfRemainingPlayers = game.getNumberOfPlayers();
    }

    public static GameMediator getInstance(Game game) {
        if (gameMediator == null) {
            gameMediator = new GameMediator(game);
        }
        return gameMediator;
    }

    public int getNumberOfRemainingPlayers() {
        return numberOfRemainingPlayers;
    }

    public void setNumberOfRemainingPlayers(int numberOfRemainingPlayers) {
        this.numberOfRemainingPlayers = numberOfRemainingPlayers;
    }


    private boolean loseTurn(Player player){
        if(!game.getCardManager().hasValidCardToPlay(player)){
            game.getCardManager().drawCards(player, game.getNoValidCardPenalty());
        }

        return !game.getCardManager().hasValidCardToPlay(player);
    }

    private Card getValidCard(Player player){
        Card card = player.getHand().getCardByIndex(
                game.getPlayerInputManager().getCardIndex(player.getHand())
        );

        while(!game.getCardManager().isPlayable(card)){
            card = player.getHand().getCardByIndex(
                    game.getPlayerInputManager().getCardIndex(player.getHand())
            );
        }

        return card;
    }

    public void playTurn(){

        Player currentPlayer = game.getTurnManager().getCurrentPlayer();

        game.getCardManager().printColorToPlay();
        System.out.println("Current Player Turn : " + currentPlayer.getName());
        currentPlayer.getHand().printPile();

        if(loseTurn(currentPlayer)){
            System.out.println("Player " + currentPlayer.getName() + " has lost turn due to no valid card to play");
            game.getTurnManager().moveToNextPlayer();
            return;
        }

        game.getCardManager().putCard(
                currentPlayer,
                getValidCard(currentPlayer)
        );

        game.getCardManager().executeCardAction(
                game.getTurnManager().getNextPlayer()
        );


        game.getStateManager().hasWon(currentPlayer);
        game.getTurnManager().moveToNextPlayer();

    }


}
