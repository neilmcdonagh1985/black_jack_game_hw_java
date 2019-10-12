import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player1;
    private Deck deck;
    private Card card1;

    @Before
    public void before() {
        player1 = new Player("Tom");
        deck = new Deck();
        card1 = new Card(SuitType.SPADES, RankType.JACK);

    }

    @Test
    public void hasName() {
       assertEquals("Tom", player1.getName());
   }

   @Test
    public void cardsStartEmpty() {
        assertEquals(0, player1.cardCount());
   }

   @Test
   public void canCountCards() {
        player1.addCard(card1);
        assertEquals(1, player1.cardCount());
   }

   @Test
    public void canAddCard() {
        player1.addCard(card1);
        assertEquals(card1, player1.getCards());
   }

   @Test
    public void canGetCards() {
        player1.addCard(card1);
        assertEquals(card1, player1.getCards());

   }

}
