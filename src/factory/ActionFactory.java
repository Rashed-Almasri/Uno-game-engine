package factory;

import engine.actions.interfaces.Action;
import enums.CardAction;

public class ActionFactory {
    public static Action getAction(CardAction action){
        return action.getEffect();
    }
}
