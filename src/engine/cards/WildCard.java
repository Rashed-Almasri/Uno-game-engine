package engine.cards;

import engine.actions.interfaces.Action;
import factory.ActionFactory;
import enums.CardAction;

public class WildCard extends Card{

    public WildCard(CardAction action, String label) {
        super.actionEffect = ActionFactory.getAction(action);
        super.setLabel(label);
        super.setAction(action);
    }

    @Override
    public String toString(){
        return getLabel();
    }
}
