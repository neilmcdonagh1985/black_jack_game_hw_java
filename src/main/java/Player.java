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

        public int cardCount() {
            return this.cards.size();

        }


        public void addCard(Card card) {
            this.cards.add(card);
        }


}

