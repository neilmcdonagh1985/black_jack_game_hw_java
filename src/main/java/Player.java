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

        public int getCards() {
            return this.cards.size();

        }

        public int receiveCard(Card card) {
            this.cards.add(card);
            return this.cards.size();
        }
}

