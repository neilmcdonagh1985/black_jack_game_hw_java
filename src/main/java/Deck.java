import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private Card card;
    private ArrayList<Card> cards;
    private ArrayList<String> suits;
    private Player player;


    public Deck(){
        this.cards = new ArrayList<Card>();

    }

    public int cardCount() {
        return this.cards.size();
    }


    public void addCardToDeck(Card cardParam) {
        this.cards.add(cardParam);

    }

    public int populateDeck() {
        for (SuitType suit : SuitType.values() ) {
            SuitType suit1 = suit;
            for (RankType rank : RankType.values()) {
                RankType rank1 = rank;
                Card newCard = new Card(suit1, rank1);
                this.cards.add(newCard);
            }

        }
        return cardCount();
    }

    public boolean shuffle() {
        Card unshuffledFirstCard = this.cards.get(0);
        Collections.shuffle(this.cards);
        Card shuffledFirstCard = this.cards.get(0);

        if (unshuffledFirstCard != shuffledFirstCard) {
            return true;
        }
        return false;
    }

    public void deal(Player player) {
        Collections.shuffle(this.cards);
        Card dealtCard = this.cards.get(0);
        player.receiveCard(dealtCard);
    }



}
