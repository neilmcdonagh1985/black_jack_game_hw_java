import java.util.ArrayList;
import java.util.Collections;

public class Dealer {

    private ArrayList<Card> ownCards;
    private ArrayList<Card> deckOfCards;


    public Dealer() {
        this.ownCards = new ArrayList<Card>();
        this.deckOfCards = new ArrayList<Card>();

    }

    public int countDeck() {
        return this.deckOfCards.size();
    }

    public int countOwnCards() {
        return this.ownCards.size();
    }

    public int populateDeckOfCards() {
        for (SuitType suit : SuitType.values() ) {
            SuitType suit1 = suit;
            for (RankType rank : RankType.values()) {
                RankType rank1 = rank;
                Card newCard = new Card(suit1, rank1);
                this.deckOfCards.add(newCard);
            }

        }
        return countDeck();
    }

    public void shuffleDeck() {
        this.populateDeckOfCards();
        Collections.shuffle(this.deckOfCards);
    }

    public boolean checkIfShuffled() {
        this.populateDeckOfCards();
        Card unshuffledFirstCard = this.deckOfCards.get(0);
        this.shuffleDeck();
        Card shuffledFirstCard = this.deckOfCards.get(0);
        if (unshuffledFirstCard != shuffledFirstCard) {
            return true;
        }
        return false;
    }

    public void dealCardtoSelf(int numberOfCards) {
        this.populateDeckOfCards();
        this.shuffleDeck();

        for (int i = 0; i < numberOfCards; i++) {
            Card card = this.deckOfCards.get(0);
            this.ownCards.add(card);
        }
    }

    public int cardCount() {
        return ownCards.size();
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
