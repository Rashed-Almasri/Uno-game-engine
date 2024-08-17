package engine.cards;

import engine.actions.interfaces.Action;
import enums.CardAction;
import enums.CardColor;
import factory.ActionFactory;

public class ActionCard extends Card{

    public ActionCard(CardAction action, CardColor color, String label) {
        super.actionEffect = ActionFactory.getAction(action);
        super.setColor(color);
        super.setLabel(label);
        super.setAction(action);
    }
}
