package engine.piles;
import engine.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    protected List<Card> pile;

    public Pile(){
        pile = new ArrayList<Card>();
    }

    public void removeCard(Card card) {
        if(pile.isEmpty()){
            throw new IllegalArgumentException("Pile is empty");
        }

        pile.remove(card);
    }

    public void addCard(Card card) {
        pile.add(card);
    }

    public List<Card> getCards() {
        return pile;
    }

    public int getSize(){
        return pile.size();
    }

    public void printPile(){
        System.out.println(pile.toString());
    }

    public Card getCardByIndex(int index){
        return pile.get(index);
    }

    public boolean isEmpty(){
        return pile.isEmpty();
    }
}
