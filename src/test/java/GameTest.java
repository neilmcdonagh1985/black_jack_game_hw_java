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
        game = new Game();
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
//    public void canStartBlackJack() {
//        game.startBlackJack();
//        dealer.acceptNewOpponent(player1);
//        dealer.acceptNewOpponent(player2);
//        assertEquals(2, dealer.countOwnCards());
//        assertEquals(2, player1.cardCount());
//        assertEquals(2, player2.cardCount());
//    }

    

//    @Test
//    public void canPlayGame() {
//        card1 = new Card(SuitType.DIAMONDS, RankType.FOUR);
//        card2 = new Card(SuitType.SPADES, RankType.KING);
//        card3 = new Card(SuitType.DIAMONDS, RankType.FIVE);
//        card4 = new Card(SuitType.HEARTS, RankType.ACE);
//        card5 = new Card(SuitType.CLUBS, RankType.FOUR);
//        player4 = new Player("Alison");
//        player5 = new Player("Yvonne");
//        game.addPlayer(player2);
//        game.addPlayer(player3);
//        game.addPlayer(player4);
//        game.addPlayer(player5);
//        player1.addCard(card4);
//        player2.addCard(card3);
//        player3.addCard(card1);
//        player4.addCard(card5);
//        player5.addCard(card2);
//        assertEquals(player5, game.play());
//    }


}
