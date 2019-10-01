import java.util.ArrayList;
import java.util.Random;
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>(54);
    Random random = new Random();
    public Deck() {
        for (int value = 0; value < CardValue.values().length; value++) {
            for (int suit = 0; suit < Suit.values().length; suit++) {
                deck.add(new Card(Suit.values()[suit], CardValue.values()[value]));
            }
        }
    }
    public Card draw() {
        if (deck.size() == 0) {
            return null;
        }
        int index = random.nextInt(deck.size());
        return deck.remove(index);
    }
    public int size() {
        return deck.size();
    }
}
