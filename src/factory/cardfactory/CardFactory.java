package factory.cardfactory;

import engine.cards.Card;
import enums.CardAction;
import enums.CardColor;

public interface CardFactory {
    public Card createCard(CardColor color, CardAction action, String label);
}
