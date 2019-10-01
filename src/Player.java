import java.util.ArrayList;
public class Player {
    ArrayList<Card> hand;
    public Player(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public Card hit(Card newCard) {
        hand.add(newCard);
        return newCard;
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

