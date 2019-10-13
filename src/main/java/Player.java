import java.util.ArrayList;

public class Player {


        private ArrayList<Card> cards;
        private String name;
        private Card card;
        private Boolean hasChosenToStick;


        public Player(String name) {
            this.name = name;
            this.cards = new ArrayList<Card>();
            this.hasChosenToStick = false;
        }

        public boolean hasChosenToStick() {
            return this.hasChosenToStick;
        }


        public String getName() {
            return this.name;
        }

        public ArrayList<Card> returnCards() {
            return this.cards;
        }

        public int cardCount() {
            return this.cards.size();

        }

        public void addCard(Card card) {
            this.cards.add(card);
        }

        public void receiveInitialBlackJackCards(Card card1, Card card2) {
            this.cards.add(card1);
            this.cards.add(card2);
        }

        public void twistOrStick(Dealer dealer, String option) {
            if (option == "twist") {
                dealer.dealThirdCardToPlayer("twist", this);
            } else {
                this.hasChosenToStick = true;
            }
        }


}

