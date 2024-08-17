package factory.cardfactory;

import engine.cards.Card;
import engine.cards.WildCard;
import enums.CardAction;
import enums.CardColor;

public class WildCardFactory implements CardFactory{
    @Override
    public Card createCard(CardColor color, CardAction action, String label) {
        return new WildCard(action, label);
    }
}
