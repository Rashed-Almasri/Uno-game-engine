package factory.cardfactory;

import engine.cards.Card;
import engine.cards.WildActionCard;
import enums.CardAction;
import enums.CardColor;

public class WildActionCardFactory implements CardFactory{

    @Override
    public Card createCard(CardColor color, CardAction action, String label) {
        return new WildActionCard(action, label);
    }
}
