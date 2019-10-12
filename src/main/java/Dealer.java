import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> cards;
    private Deck deck;


    public Dealer() {
        this.cards = new ArrayList<Card>();
    }

    public void takeCard() {
        deck.shuffle();
        Card card = deck.pickTopCard();
        this.cards.add(card);
    }

    public int cardCount() {
        return cards.size();
    }

//    public void deal(int numberOfCards) {
//        deck.shuffle();
//        for (i = 0; i < numberOfCards; i++) {
//            this.takeCard();
//        }
//
//
//
//    }


}
