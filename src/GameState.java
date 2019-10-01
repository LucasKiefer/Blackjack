import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class GameState {
    Deck deck;
    Player player;
    Dealer dealer;
    int startingChips;
    public GameState(int startingchips) {
        this.startingChips = startingchips;
        this.deck = new Deck();
        this.dealer = new Dealer(deck.draw(), deck.draw());
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(deck.draw());
        hand.add(deck.draw());
        this.player = new Player(hand);
    }
    public int run() {
        System.out.println("What's your bet?");
        int bet = InputUtil.getIntInput();
        if (dealer.sumHand() == 21) {
            if (player.sumHand() != 21) {
                System.out.println("The dealer has blackjack! You lose.");
                return startingChips - bet;
            } else {
                System.out.println("You both have blackjack! It's a push.");
                return startingChips;
            }
        } else if (player.sumHand() == 21) {
            System.out.println("You have blackjack! You get double chips back!");
            return startingChips + bet * 2;
        }
        boolean gameActive = true;
        while (gameActive) {
            System.out.println("The dealer has a " + dealer.getSeen() + " and an unknown card. You have a ");
            for (int i = 0; i < player.getHand().size() - 1; i++) {
                System.out.print(" a " + player.getHand().get(i) + ", ");
            }
            System.out.println("and a " + player.getHand().get(player.getHand().size() - 1));
            System.out.println("Would you like to hit or pass?");
            if (InputUtil.getHitInput()) {
                System.out.println("You drew a " + player.hit(deck.draw()));
                if (player.sumHand() > 21) {
                    System.out.println("Your hand adds up to " + player.sumHand()
                            + ", which is above 21. You lose this round.");
                    return startingChips - bet;
                }
            } else {
                gameActive = false;
                if (dealer.playHand(deck)) {
                    if (dealer.sumHand() > player.sumHand()) {
                        System.out.println("Your total was " + player.sumHand() + ", so the dealer wins!");
                        return startingChips - bet;
                    } else if (dealer.sumHand() == player.sumHand()) {
                        System.out.println("Your total was " + player.sumHand() + ", so you push!");
                        return startingChips;
                    }
                    else {
                        System.out.println("Your total was " + player.sumHand() + ", so you win!");
                        return startingChips + bet;
                    }
                } else {
                    System.out.println("The dealer went over. You win!");
                }
            }
        }
        return startingChips - bet;
    }

}
