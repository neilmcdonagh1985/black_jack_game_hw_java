import java.util.ArrayList;
import java.util.Collections;

public class Dealer {

    private ArrayList<Card> ownCards;
    private ArrayList<Card> deckOfCards;
    private ArrayList<Player> opponents;
    private boolean hasChosenToStick;


    public Dealer() {
        this.ownCards = new ArrayList<Card>();
        this.deckOfCards = new ArrayList<Card>();
        this.opponents = new ArrayList<Player>();
        this.hasChosenToStick = false;

    }

    public boolean hasChosenToStick() {
        return this.hasChosenToStick;
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

    public void populateDeckOfCards() {
        for (SuitType suit : SuitType.values()) {
            SuitType suit1 = suit;
            for (RankType rank : RankType.values()) {
                RankType rank1 = rank;
                Card newCard = new Card(suit1, rank1);
                this.deckOfCards.add(newCard);
            }
        }
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

    public void acceptNewOpponent(Player player) {
        this.opponents.add(player);
    }

    public int returnDealerTotal() {
        int dealerTotal = 0;
        for (Card card : this.ownCards) {
            dealerTotal += card.getValueFromEnum();
        }
        return dealerTotal;
    }

//    public Player returnHighestScoringPlayer() {
//        int highestTotal = 0;
//        Player highestScoringPlayer = null;
//        for (Player opponent : this.opponents) {
//            int playerTotal = 0;
//            for (Card card : opponent.returnCards()) {
//                playerTotal += card.getValueFromEnum();
//
//            }
//            if (playerTotal > highestTotal) {
//                highestTotal = playerTotal;
//                highestScoringPlayer = opponent;
//            }
//        }
////        return highestTotal;
//        return highestScoringPlayer;
//    }

    public void dealToOpponent(Card card1, Card card2) {
        for(Player player: this.opponents) {
            player.receiveInitialBlackJackCards(card1, card2);
        }
    }

    public void dealToSelf(Card card3, Card card4) {
        this.ownCards.add(card3);
        this.ownCards.add(card4);
    }

    public String findHigherHand() {
        String DealerWins = "Dealer wins";
        int dealerTotal = 0;
        for (Card card : this.ownCards) {
            dealerTotal += card.getValueFromEnum();
        }
        String PlayerWins = "Player wins";
        int playerTotal = 0;
        for (Player player : this.opponents) {
            for (Card card : player.returnCards()) {
                playerTotal += card.getValueFromEnum();
            }
            if (dealerTotal > playerTotal) {
                return DealerWins;
            }
        }
        return PlayerWins;
    }

    public void dealThirdCardToPlayer(String option, Player player) {
        if (option == "twist") {
            this.shuffleDeck();
            Card card = this.deckOfCards.get(0);
            player.addCard(card);
        }
    }

    public void chooseIfTwistorStick() {
        int dealerTotal = 0;
        for (Card card : this.ownCards) {
            dealerTotal += card.getValueFromEnum();
        }
        if (dealerTotal < 16) {
            this.twist();
        } else {
            this.stick();
        }
    }

    public void twist() {
        this.shuffleDeck();
        Card card = this.deckOfCards.get(0);
        this.ownCards.add(card);
    }

    public void stick() {
        this.returnDealerTotal();
    }



}




