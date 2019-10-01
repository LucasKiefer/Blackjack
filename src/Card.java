public class Card {
    private Suit suit;
    private CardValue cardValue;
    public Card(Suit suit, CardValue cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    private Suit getSuit() {
        return suit;
    }

    public void setCardValue(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Card)) {
            return false;
        } else {
            return ((Card) obj).getSuit() == this.getSuit() && ((Card) obj).getCardValue() == this.getCardValue();
        }
    }

    @Override
    public String toString() {
        return "" +this.cardValue + " of " + this.suit;
    }
}
