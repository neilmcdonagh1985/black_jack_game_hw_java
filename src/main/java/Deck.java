import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private Card card;
    private ArrayList<Card> cards;
    private ArrayList<String> suits;
    private Player player;
    private ArrayList<Card> pickedCards;


    public Deck(){
        this.cards = new ArrayList<Card>();
        this.pickedCards = new ArrayList<Card>();

    }

    public int cardCount() {
        return this.cards.size();
    }

    public int pickedCardCount() {
        return this.pickedCards.size();
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
        this.populateDeck();
        Card unshuffledFirstCard = this.cards.get(0);
        Collections.shuffle(this.cards);
        Card shuffledFirstCard = this.cards.get(0);

        if (unshuffledFirstCard != shuffledFirstCard) {
            return true;
        }
        return false;
    }

    public Card pickTopCard() {
        this.populateDeck();
        this.shuffle();
        Card chosenCard = this.cards.get(0);
        pickedCards.add(chosenCard);
        return chosenCard;

    }

    public void deal(Player player, int numberOfCards) {
        this.populateDeck();
        Collections.shuffle(this.cards);

        // for as many times as the numberOfCards passed in... do this...
        for (int i = 0; i < numberOfCards; i++) {
            Card dealtCard = this.cards.get(0);
            player.addCard(dealtCard);
        }

    }



}
