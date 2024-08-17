package engine;

import engine.cards.Card;
import engine.players.Player;
import enums.CardAction;
import enums.CardColor;
import factory.CardFactory;
import engine.managers.*;
import java.util.List;

public class OfficialUno extends Game{

    protected OfficialUno(List<Player> players) {
        super(players);

        super.setCardManager(StandardCardManager.getInstance(this));
        super.setTurnManager(StandardTurnManager.getInstance(players));
        super.setPlayerInputManager(StandardPlayerInputManager.getInstance());
        super.setStateManager(StandardStateManager.getInstance(this));

        initDeck();
    }

    @Override
    protected void initDeck() {
        for(CardColor color : CardColor.values()) {
            for(int i = 0; i <= 9; i++){
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.None, String.valueOf(i)));
            }
        }
        for(CardColor color : CardColor.values()) {
            for(int i = 1; i <= 9; i++){
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.None, String.valueOf(i)));
            }
        }
        for(CardColor color : CardColor.values()) {
            for(int i = 0; i < 2; i++){
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.SkipTurn, "Skip Turn"));
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.SkipTurn, "Skip Turn"));
            }
            for(int i = 0; i < 2; i++){
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.ReverseTurn, "Reverse Turn"));
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.ReverseTurn, "Reverse Turn"));
            }
            for(int i = 0; i < 2; i++){
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.DrawTwo, "Draw Two"));
                super.getGameDeck().addCard(CardFactory.getCard(color, CardAction.DrawTwo, "Draw Two"));
            }
        }

        for(int i = 0; i < 4; i++){
            super.getGameDeck().addCard(CardFactory.getCard(null, CardAction.DrawFour, "Draw Four"));
            super.getGameDeck().addCard(CardFactory.getCard(null, CardAction.ChangeColor, "Change Color"));
        }

        getGameDeck().shuffle();
        for(Player player : getPlayers()) {
            getCardManager().drawCards(player, 7);
        }
    }


    @Override
    protected void play() {
        System.out.println(getGameDeck().getSize());
        while (!super.gameOver) {
            getGameMediator().playTurn();
            for(Player player : getPlayers()){
                System.out.print(player.getName() + " : "+ player.getHand().getSize() + " | ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean winingCondition(Player player) {
        return player.getHand().isEmpty();
    }

}
