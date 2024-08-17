package engine;

import java.util.ArrayList;
import java.util.List;
import engine.players.Player;

public class GameDriver {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Rashed"));
        players.add(new Player("anas"));
        players.add(new Player("hussss"));
        players.add(new Player("yahya"));
        Game game = new OfficialUno(players);
        game.play();
    }
}
