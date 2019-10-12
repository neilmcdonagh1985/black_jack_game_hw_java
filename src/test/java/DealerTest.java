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
    public void checkHasCards() {
        dealer.takeCard();
        dealer.takeCard();
        assertEquals(2, dealer.cardCount());
    }

//    @Test
//    public void canTakeTopCard() {
//        dealer.takeCard();
//        assertEquals(1, dealer.cardCount());
//    }

}
