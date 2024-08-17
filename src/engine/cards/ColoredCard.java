package engine.cards;

import enums.CardAction;
import enums.CardColor;
import engine.actions.interfaces.Action;
import factory.ActionFactory;

public class ColoredCard extends Card{

    public ColoredCard(CardColor color, String label){
        super.setColor(color);
        super.setLabel(label);
        super.setAction(CardAction.None);
        super.actionEffect = ActionFactory.getAction(CardAction.None);
    }

}
