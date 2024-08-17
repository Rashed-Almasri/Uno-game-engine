package factory;

import engine.cards.*;
import enums.CardAction;
import enums.CardColor;

public class CardFactory {
    public static Card getCard(CardColor color, CardAction action, String label){
        if(action == CardAction.DrawFour){
            return new WildActionCard(action, label);
        }
        if(action == CardAction.DrawTwo || action == CardAction.SkipTurn || action == CardAction.ReverseTurn){
            return new ActionCard(action, color, label);
        }
        if(action == CardAction.ChangeColor){
            return new WildCard(action, label);
        }
        return new ColoredCard(color, label);
    }
}
