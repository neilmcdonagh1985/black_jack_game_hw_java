import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Player player;



    public Game() {
        this.players = new ArrayList<Player>();
    }

    public int playerCount() {
        return players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

//    public Player play() {
//
//        int winningNumber = 0;
//        Player winner = null;
//        for (Player player :this.players ) {
//            Card card = player.getCards();
//            int playerCardValue = card.getValueFromEnum();
//            if (playerCardValue > winningNumber) {
//                winningNumber = playerCardValue;
//                winner = player;
//
//            }
//        }
//        return winner;
//    }



}
