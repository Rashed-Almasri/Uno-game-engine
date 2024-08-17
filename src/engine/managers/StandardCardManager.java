package engine.managers;

import engine.cards.Card;
import engine.cards.WildActionCard;
import engine.cards.WildCard;
import engine.managers.interfaces.CardManager;
import engine.players.Player;
import enums.CardColor;
import engine.Game;

public class StandardCardManager implements CardManager {
    private static StandardCardManager standardCardManager;
    private CardColor colorToPlay;
    private final Game game;

    private StandardCardManager(Game game) {
        this.game = game;
    }

    public static StandardCardManager getInstance(Game game) {
        if(standardCardManager == null){
            standardCardManager = new StandardCardManager(game);
        }
        return standardCardManager;
    }

    @Override
    public boolean hasValidCardToPlay(Player player){
        for(Card card : player.getHand().getCards()){
            if(isPlayable(card)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void changeGameColor(CardColor colorToPlay) {
        this.colorToPlay = colorToPlay;
    }

    @Override
    public void printColorToPlay(){
//        System.out.println(game.getDiscardPile().getTopCard().toString());
        System.out.println("Color to play : " + (colorToPlay == null ? "Any color is valid !" : colorToPlay.toString()));
    }

    @Override
    public void executeCardAction(Player player){
        if(game.getDiscardPile().isEmpty()){
            return;
        }

        game.getDiscardPile().getTopCard().getActionEffect().executeAction(game, player);
    }

    @Override
    public CardColor getColorToPlay(){
        if(game.getDiscardPile().isEmpty()){
            return null;
        }
        return game.getDiscardPile().getTopCard().getColor();
    }

    @Override
    public boolean isPlayable(Card card){
        if(game.getDiscardPile().isEmpty()){
            return true;
        }

        Card topCard = game.getDiscardPile().getTopCard();
        return (card instanceof WildCard || card instanceof WildActionCard || card.getLabel().equals(topCard.getLabel()) || card.getColor() == topCard.getColor());
    }

    @Override
    public void drawCards(Player player, int cardsCount){
        for (int i = 0; i < cardsCount; i++){
            player.addToHand(game.getGameDeck().getTopCard());
            game.getGameDeck().removeTopCard();
        }
    }

    @Override
    public void putCard(Player player, Card card){
        game.getDiscardPile().addCard(card);
        player.removeFromHand(card);
        changeGameColor(card.getColor());
    }
}
