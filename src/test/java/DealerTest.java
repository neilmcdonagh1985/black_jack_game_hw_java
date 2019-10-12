import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Player player1;
    private Player player2;
    private Player player3;
    private Dealer dealer;
    private Card card1;
    private Card card2;


    @Before
    public void before(){
        dealer = new Dealer();
        card1 = new Card(SuitType.CLUBS, RankType.NINE);
        card2 = new Card(SuitType.HEARTS, RankType.JACK);
    }

    @Test
    public void hasDeckOfCards() {
        dealer.populateDeckOfCards();
        assertEquals(52, dealer.countDeck());
    }

    @Test public void canShuffle() {
        dealer.shuffleDeck();
        assertEquals(true, dealer.checkIfShuffled());
    }

    @Test
    public void canDealCardtoSelf() {
        dealer.dealCardtoSelf(5);
        assertEquals(5, dealer.countOwnCards());
    }

    @Test
    public void canAcceptNewOpponents() {
        player1 = new Player("Caoimhe");
        player2 = new Player("Higgy");
        player3 = new Player("Nathan");
        dealer.acceptNewOpponent(player1);
        dealer.acceptNewOpponent(player2);
        dealer.acceptNewOpponent(player3);
        assertEquals(3, dealer.countOpponents());
    }

    @Test
    public void canDealCardsToPlayers() {
        player1 = new Player("Caoimhe");
        player2 = new Player("Higgy");
        dealer.acceptNewOpponent(player1);
        dealer.acceptNewOpponent(player2);
        dealer.dealCardsToPlayers(4);
        assertEquals(4, player2.cardCount());
    }

    @Test
    public void canStartBlackJack() {
        player1 = new Player("Caoimhe");
        player2 = new Player("Higgy");
        dealer.acceptNewOpponent(player1);
        dealer.acceptNewOpponent(player2);
        dealer.startBlackJack();
        assertEquals(2, dealer.countOwnCards());
        assertEquals(2, player1.cardCount());
        assertEquals(2, player2.cardCount());
    }


//    @Test
//    public void checkHasCards() {
//        dealer.takeCard();
//        dealer.takeCard();
//        assertEquals(2, dealer.cardCount());
//    }

//    @Test
//    public void canTakeTopCard() {
//        dealer.takeTopCard();
//        assertEquals(1, dealer.cardCount());
//    }

}
