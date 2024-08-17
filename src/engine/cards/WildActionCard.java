package engine.cards;
import enums.CardAction;
import engine.actions.interfaces.Action;
import factory.ActionFactory;

public class WildActionCard extends Card{

    public WildActionCard(CardAction action, String label) {
        super.actionEffect = ActionFactory.getAction(action);
        super.setLabel(label);
        super.setAction(action);
    }

    @Override
    public String toString(){
        return getLabel();
    }
}
