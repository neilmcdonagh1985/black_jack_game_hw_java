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

    @Test
    public void canReturnDealerTotal() {
        dealer.addCardToSelf(card1);
        dealer.addCardToSelf(card2);
        assertEquals(19, dealer.returnDealerTotal());
    }

    @Test
    public void canReturnHighestScoringPlayer() {
        player1 = new Player("Caoimhe");
        player2 = new Player("Higgy");
        player1.addCard(card4);
        player1.addCard(card3);
        player2.addCard(card5);
        player2.addCard(card1);
        dealer.acceptNewOpponent(player1);
        dealer.acceptNewOpponent(player2);
        assertEquals(player1, dealer.returnHighestScoringPlayer());
    }

    @Test
    public void canDealtoOpponent() {
        player2 = new Player("Higgy");
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
    public void canFindHigherHand() {
        player2 = new Player("Higgy");
        dealer.acceptNewOpponent(player2);
        dealer.dealToOpponent(card1, card2);
        dealer.dealToSelf(card3, card4);
        assertEquals(19, dealer.findHigherHand());
    }

    @Test
    public void canRevealPersonWithHigherHand() {
        player2 = new Player("Higgy");
        dealer.acceptNewOpponent(player2);
        dealer.dealToOpponent(card1, card2);
        dealer.dealToSelf(card3, card4);
        assertEquals("Player wins", dealer.findHigherHand());
    }

//    @Test
//    public void canFindWinner() {
//        dealer.acceptNewOpponent(player2);
//
//    }


    }

//    @Test
//    public void canTotalScoresOfTwoCards() {
//        player1 = new Player("Caoimhe");
//        dealer.acceptNewOpponent(player1);
//        player1.addCard(card1);
//        player1.addCard(card2);
//        dealer.addCardToSelf(card3);
//        dealer.addCardToSelf(card4);
//        assertEquals(player1, dealer.compareHands());
//    }


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
//
//}
