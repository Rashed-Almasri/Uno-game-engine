package factory.cardfactory;

import engine.cards.ActionCard;
import engine.cards.Card;
import enums.CardAction;
import enums.CardColor;

public class ActionCardFactory implements CardFactory {
    @Override
    public Card createCard(CardColor color, CardAction action, String label) {
        return new ActionCard(color, action, label);
    }
}
