package factory.cardfactory;

import engine.cards.Card;
import engine.cards.ColoredCard;
import enums.CardAction;
import enums.CardColor;

public class ColoredCardFactory implements CardFactory {

    @Override
    public Card createCard(CardColor color, CardAction action, String label) {
        return new ColoredCard(color, label);
    }
}
