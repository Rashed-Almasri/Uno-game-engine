package engine;

import engine.players.Player;
import enums.CardAction;
import enums.CardColor;
import factory.CardFactory;
import engine.managers.*;
import factory.cardfactory.*;

import java.util.List;

public class OfficialUno extends Game{

    protected OfficialUno(List<Player> players) {
        super(players);

        super.setCardManager(StandardCardManager.getInstance(this));
        super.setTurnManager(StandardTurnManager.getInstance(players));
        super.setPlayerInputManager(StandardPlayerInputManager.getInstance());
        super.setStateManager(StandardStateManager.getInstance(this));

        initDeck();
        dealCardsToPlayers();
    }

    @Override
    protected void initDeck() {
        CardFactory actionCardFactory = new ActionCardFactory();
        CardFactory wildCardFactory = new WildCardFactory();
        CardFactory wildActionCardFactory = new WildActionCardFactory();
        CardFactory coloredCardFactory = new ColoredCardFactory();

        for(CardColor color : CardColor.values()) {
            for(int i = 0; i <= 9; i++){
                super.getGameDeck().addCard(coloredCardFactory.createCard(color, CardAction.None, String.valueOf(i)));
            }
        }
        for(CardColor color : CardColor.values()) {
            for(int i = 1; i <= 9; i++){
                super.getGameDeck().addCard(coloredCardFactory.createCard(color, CardAction.None, String.valueOf(i)));
            }
        }
        for(CardColor color : CardColor.values()) {
            for(int i = 0; i < 2; i++){
                super.getGameDeck().addCard(actionCardFactory.createCard(color, CardAction.SkipTurn, "Skip Turn"));
                super.getGameDeck().addCard(actionCardFactory.createCard(color, CardAction.SkipTurn, "Skip Turn"));
            }
            for(int i = 0; i < 2; i++){
                super.getGameDeck().addCard(actionCardFactory.createCard(color, CardAction.ReverseTurn, "Reverse Turn"));
                super.getGameDeck().addCard(actionCardFactory.createCard(color, CardAction.ReverseTurn, "Reverse Turn"));
            }
            for(int i = 0; i < 2; i++){
                super.getGameDeck().addCard(actionCardFactory.createCard(color, CardAction.DrawTwo, "Draw Two"));
                super.getGameDeck().addCard(actionCardFactory.createCard(color, CardAction.DrawTwo, "Draw Two"));
            }
        }

        for(int i = 0; i < 4; i++){
            super.getGameDeck().addCard(wildActionCardFactory.createCard(null, CardAction.DrawFour, "Draw Four"));
            super.getGameDeck().addCard(wildCardFactory.createCard(null, CardAction.ChangeColor, "Change Color"));
        }

        getGameDeck().shuffle();

    }

    @Override
    protected void dealCardsToPlayers() {
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
