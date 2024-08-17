package engine.players;
import engine.cards.Card;
import engine.piles.Pile;
import enums.CardColor;

import java.util.Scanner;

public class Player {
    private final String name;
    private final Pile hand;

    public Player(String name) {
        this.name = name;
        hand = new Pile();
    }

    public String getName() {
        return name;
    }
    public Pile getHand() {
        return hand;
    }

    public void addToHand(Card card) {
        hand.addCard(card);
    }

    public void removeFromHand(Card card) {
        hand.removeCard(card);
    }
}
