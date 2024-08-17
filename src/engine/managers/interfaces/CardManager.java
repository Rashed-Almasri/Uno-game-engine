package engine.managers.interfaces;

import engine.cards.Card;
import engine.players.Player;
import enums.CardColor;

public interface CardManager {

    CardColor getColorToPlay();

    boolean isPlayable(Card card);

    void drawCards(Player player, int cardsCount);

    void putCard(Player player, Card card);

    public void executeCardAction(Player player);

    public boolean hasValidCardToPlay(Player player);

    public void printColorToPlay();

    public void changeGameColor(CardColor color);

}

