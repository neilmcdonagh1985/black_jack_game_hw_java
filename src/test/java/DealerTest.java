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
    private Card card3;
    private Card card4;
    private Card card5;


    @Before
    public void before(){
        dealer = new Dealer();
        card1 = new Card(SuitType.CLUBS, RankType.NINE);
        card2 = new Card(SuitType.HEARTS, RankType.JACK);
        card3 = new Card(SuitType.HEARTS, RankType.KING);
        card4 = new Card(SuitType.DIAMONDS, RankType.SIX);
        card5 = new Card(SuitType.CLUBS, RankType.FOUR);
        player1 = new Player("Caoimhe");
        player2 = new Player("Higgy");
        player3 = new Player("Nathan");
    }

    @Test
    public void hasChosenToStick() {
        assertEquals(false, dealer.hasChosenToStick());
    }

    @Test
    public void hasDeckOfCards() {
        dealer.populateDeckOfCards();
        assertEquals(52, dealer.countDeck());
    }

    @Test
    public void canAddCard() {
        dealer.addCardToSelf(card1);
        assertEquals(1, dealer.countOwnCards());
    }

    @Test public void canShuffle() {
        dealer.shuffleDeck();
        assertEquals(true, dealer.checkIfShuffled());
    }

    @Test
    public void canAcceptNewOpponents() {
        dealer.acceptNewOpponent(player1);
        dealer.acceptNewOpponent(player2);
        dealer.acceptNewOpponent(player3);
        assertEquals(3, dealer.countOpponents());
    }

    @Test
    public void canReturnDealerTotal() {
        dealer.addCardToSelf(card1);
        dealer.addCardToSelf(card2);
        assertEquals(19, dealer.returnDealerTotal());
    }

    @Test
    public void canDealtoOpponent() {
        dealer.acceptNewOpponent(player2);
        dealer.dealToOpponent(card1, card2);
        assertEquals(2, player2.cardCount());
    }

    @Test
    public void canDealToSelf() {
        dealer.dealToSelf(card3, card4);
        assertEquals(2, dealer.countOwnCards());
    }

    @Test
    public void canRevealPersonWithHigherHand() {
        dealer.acceptNewOpponent(player2);
        dealer.dealToOpponent(card1, card2);
        dealer.dealToSelf(card3, card4);
        assertEquals("Player wins", dealer.findHigherHand());
    }

    @Test
    public void canDealThirdCard() {
        player1.addCard(card1);
        player1.addCard(card2);
        dealer.dealThirdCardToPlayer("twist", player1);
        assertEquals(3, player1.cardCount());
    }

    @Test
    public void canTwist() {
        dealer.dealToSelf(card3, card5);
        dealer.chooseIfTwistorStick();
        assertEquals(3, dealer.countOwnCards());
    }

    @Test
    public void canStick() {
        dealer.dealToSelf(card1, card3);
        dealer.chooseIfTwistorStick();
        assertEquals(2, dealer.countOwnCards());
    }



    }


