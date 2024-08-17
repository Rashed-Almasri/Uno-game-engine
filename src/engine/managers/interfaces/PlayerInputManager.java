package engine.managers.interfaces;

import engine.piles.Pile;
import enums.CardColor;

public interface PlayerInputManager {
    public CardColor getColor();
    public int getCardIndex(Pile playerHand);
}
