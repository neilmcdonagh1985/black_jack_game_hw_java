import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

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
