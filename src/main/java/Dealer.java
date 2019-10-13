import java.util.ArrayList;
import java.util.Collections;

public class Dealer {

    private ArrayList<Card> ownCards;
    private ArrayList<Card> deckOfCards;
    private ArrayList<Player> opponents;


    public Dealer() {
        this.ownCards = new ArrayList<Card>();
        this.deckOfCards = new ArrayList<Card>();
        this.opponents = new ArrayList<Player>();

    }

    public int countDeck() {
        return this.deckOfCards.size();
    }

    public void addCardToSelf(Card card) {
        this.ownCards.add(card);
    }

    public int countOwnCards() {
        return this.ownCards.size();
    }

    public int countOpponents() {
        return this.opponents.size();
    }

    public int populateDeckOfCards() {
        for (SuitType suit : SuitType.values()) {
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
        this.shuffleDeck();

        for (int i = 0; i < numberOfCards; i++) {
            Card card = this.deckOfCards.get(0);
            this.ownCards.add(card);
        }
    }

    public void acceptNewOpponent(Player player) {
        this.opponents.add(player);
    }


    public void dealCardsToPlayers(int numberOfCards) {
        this.shuffleDeck();
        Card card = this.deckOfCards.get(0);
        for (Player player : this.opponents) {
            for (int i = 0; i < numberOfCards; i++) {
                player.addCard(card);
            }
        }
    }

    public void startBlackJack() {
        dealCardtoSelf(2);
        dealCardsToPlayers(2);
    }

    public int returnDealerTotal() {
        int dealerTotal = 0;
        for (Card card : this.ownCards) {
            dealerTotal += card.getValueFromEnum();
        }
        return dealerTotal;
    }

    public Player returnHighestScoringPlayer() {
        int highestTotal = 0;
        Player highestScoringPlayer = null;
        for (Player opponent : this.opponents) {
            int playerTotal = 0;
            for (Card card : opponent.returnCards()) {
                playerTotal += card.getValueFromEnum();

            }
            if (playerTotal > highestTotal) {
                highestTotal = playerTotal;
                highestScoringPlayer = opponent;
            }
        }
//        return highestTotal;
        return highestScoringPlayer;
    }
}




