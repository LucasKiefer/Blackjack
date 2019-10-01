import java.sql.SQLOutput;
import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand = new ArrayList<Card>();
    public Dealer(Card unseen, Card seen) {
        hand.add(unseen);
        hand.add(seen);
    }
    public int countAmount() {
        return 0;
    }

    public Card getSeen() {
        return hand.get(0);
    }


    public boolean playHand(Deck deck) {
        System.out.println("The dealer's other card was " + hand.get(1));
        while (this.sumHand() < 17) {
            Card currentCard = deck.draw();
            hand.add(currentCard);
            System.out.println("The dealer hit and got a "
                    + currentCard + ". Their total is " + this.sumHand());
        }
        return this.sumHand() <= 21;
    }

    public int sumHand() {
        int sum = 0;
        int aces = 0;
        for (Card card : hand) {
            if (card.getCardValue().getCardValue() >= 10) {
                if (card.getCardValue().getCardValue() == 14) {
                    aces++;
                } else {
                    sum += 10;
                }
            } else {
                sum += card.getCardValue().getCardValue();
            }
        }
        for (int i = 0; i < aces; i++) {
            if (sum + 11 + aces - i - 1 <= 21) {
                sum += 11;
            } else {
                sum++;
            }
        }
        return sum;
    }
}
