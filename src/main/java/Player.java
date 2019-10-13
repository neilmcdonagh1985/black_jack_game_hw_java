import java.util.ArrayList;

public class Player {


        private ArrayList<Card> cards;
        private String name;
        private Card card;


        public Player(String name) {
            this.name = name;
            this.cards = new ArrayList<Card>();
        }


        public String getName() {
            return this.name;
        }

        public Card getCards() {
            for (Card card : this.cards) {
                return card;
            }
            return card;
        }

        public ArrayList<Card> returnCards() {
            return this.cards;
//            ArrayList<Card> cards = new ArrayList<Card>();
//            return(cards);
        }



//        public int getTotalValueOfCards() {
//            int total = 0;
//            for (Card card : this.cards) {
//                total += card.getValueFromEnum();
//            }
//            return total;
//        }

        public int cardCount() {
            return this.cards.size();

        }


        public void addCard(Card card) {
            this.cards.add(card);
        }


}

