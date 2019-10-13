import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Player player;
    private Dealer dealer;


     public Game(Dealer dealer) {
        this.players = new ArrayList<Player>();
        this.dealer = dealer;
    }

    public int playerCount() {
        return players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public String compareHandsAfterBothHaveStuck() {
         for (Player player : this.players) {
             if (player.hasChosenToStick() && dealer.hasChosenToStick()) {
                 
             }
    }





}
