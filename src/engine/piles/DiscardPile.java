package engine.piles;

import engine.cards.Card;

public class DiscardPile extends Pile{
    private static DiscardPile discardPile;

    private DiscardPile() {
        super();
    }

    public static DiscardPile getInstance() {
        if (discardPile == null) {
            discardPile = new DiscardPile();
        }
        return discardPile;
    }

    public Card getTopCard(){
        if(isEmpty()){
            throw new IllegalArgumentException("Empty deck");
        }
        return pile.getLast();
    }

}
