import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Player player5;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;
    private Deck deck;
    private Dealer dealer;

    @Before
    public void before() {
        game = new Game(dealer);
        player1 = new Player("Caoimhe");
        player2 = new Player("Higgy");
        player3 = new Player("Nathan");
        deck = new Deck();
        dealer = new Dealer();


    }

//    @Test
//    public void canGetAllPlayers() {
//        game.addPlayer(player1);
//        game.addPlayer(player2);
//        game.addPlayer(player3);
//        assertEquals(0, game.getAllPlayers());
//    }

    @Test
    public void gameHasPlayers() {
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(2, game.playerCount());
    }

//    @Test
//    public void hasDealer() {
//        assertEquals(true, game.hasDealer());
//    }

//    @Test
//    public void canCompareHandsAfterBothHaveStuck() {
//        assertEquals("Player1 has the highest hand", game.compareHandsAfterBothHaveStuck);
//    }

}
