import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player1;
    private Deck deck;
    private Card card1;
    private Card card2;
    private Dealer dealer;

    @Before
    public void before() {
        player1 = new Player("Alison");
        deck = new Deck();
        card1 = new Card(SuitType.SPADES, RankType.JACK);
        card2 = new Card(SuitType.DIAMONDS, RankType.FIVE);
        dealer = new Dealer();

    }

    @Test
    public void CheckIfHasChosenToStick() {
        assertEquals(false, player1.hasChosenToStick());
    }

    @Test
    public void hasName() {
       assertEquals("Alison", player1.getName());
   }

   @Test
    public void cardsStartEmpty() {
        assertEquals(0, player1.cardCount());
   }

   @Test
   public void canCountCards() {
        player1.addCard(card1);
        player1.addCard(card2);
        assertEquals(2, player1.cardCount());
   }

   @Test
    public void canAddCard() {
        player1.addCard(card1);
        assertEquals(1, player1.cardCount());
   }

    @Test
    public void canTwist() {
        player1.addCard(card1);
        player1.addCard(card2);
        player1.twistOrStick(dealer, "twist");
        assertEquals(3, player1.cardCount());
    }

    @Test
    public void canStick() {
        player1.addCard(card1);
        player1.addCard(card2);
        player1.twistOrStick(dealer, "stick");
        assertEquals(true, player1.hasChosenToStick());
    }

}
