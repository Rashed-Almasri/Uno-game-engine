package factory;

import engine.actions.interfaces.Action;
import enums.CardAction;
import engine.actions.*;

public class ActionFactory {
    public static Action getAction(CardAction action){

        if(action == CardAction.DrawFour){
            return new DrawFour();
        }
        if(action == CardAction.DrawTwo){
            return new DrawTwo();
        }
        if(action == CardAction.SkipTurn){
            return new Skip();
        }
        if(action == CardAction.ReverseTurn){
            return new ReverseTurn();
        }
        if(action == CardAction.ChangeColor){
            return new ChangeColor();
        }
        return new NoAction();
    }

}
