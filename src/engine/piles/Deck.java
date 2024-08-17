package engine.piles;
import engine.cards.Card;

import java.util.Collections;

public class Deck extends Pile{
    private static Deck deck;
    private Deck(){
        super();
    }

    public static Deck getInstance(){
        if(deck == null){
            deck = new Deck();
        }
        return deck;
    }

    public void shuffle(){
        Collections.shuffle(pile);
    }

    public Card getTopCard(){
        if(super.isEmpty()){
            throw new IllegalArgumentException("Empty deck");
        }
        return pile.getLast();
    }

    public void removeTopCard(){
        if(pile.isEmpty()){
            throw new IllegalArgumentException("Empty deck");
        }

        pile.removeLast();
    }
}
