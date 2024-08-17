package enums;

import engine.actions.*;
import engine.actions.interfaces.Action;

public enum CardAction {
    None{
        @Override
        public Action getEffect(){
            return new NoAction();
        }
    },
    DrawFour{
        @Override
        public Action getEffect(){
            return new DrawFour();
        }
    },
    DrawTwo{
        @Override
        public Action getEffect(){
            return new DrawTwo();
        }
    },
    SkipTurn{
        @Override
        public Action getEffect(){
            return new Skip();
        }
    },
    ReverseTurn{
        @Override
        public Action getEffect(){
            return new ReverseTurn();
        }
    },
    ChangeColor{
        @Override
        public Action getEffect(){
            return new ChangeColor();
        }
    };

    public abstract Action getEffect();
}
