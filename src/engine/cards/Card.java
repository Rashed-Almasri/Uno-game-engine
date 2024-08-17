package engine.cards;
import engine.actions.interfaces.Action;
import enums.*;

public abstract class Card {
    private String label;
    private CardColor color;
    private CardAction action;
    protected Action actionEffect;

    protected Card(){
        this.label = "";
        this.color = null;
        this.action = CardAction.None;
    }

    public String getLabel() {
        return label;
    }
    protected void setColor(CardColor color) {
        this.color = color;
    }
    public CardColor getColor() {
        return color;
    }
    protected void setAction(CardAction action) {
        this.action = action;
    }
    protected void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString(){
        return getLabel() + " " + getColor();
    }

    public Action getActionEffect() {
        return actionEffect;
    }


}
