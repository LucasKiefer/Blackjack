# Design Documents
## How to run
Welcome to the design documents for this game. This game was coded entirely in Java 8, so please make sure it is installed before running. Now, to run the actual game, run the following command from the main directory:

```java -jar Blackjack.jar```

## Design Decisions
#### Language Choice
I chose to code this game entirely in Java 8 for a few reasons. First, because Java's enums and classes make the game much easier to understand from a design perspective, as well as a coding perspective. Object oriented programming for a game that's built around objects such as cards just makes the most sense. Additionally, I have experience in writing in Java, which makes the coding much easier. The final reason I'll mention, is that being able to take the whole game and condense it into a single jar file makes running it much easier.
#### Classes and Enums: Why?
I used classes and enums as they make the organization of the entire project much simpler. Here is a list of each class/enum and what it does:
* Main: the main class. Runs the game, keeps track of the amount of chips the player has, and the current game state.
* GameState: a class representing the game state that is being run. Controls game logic, as well as the current player, dealer, and deck objects.
* Dealer: a class representing the dealer. The dealer has a hand, and then can play their turn.
* Player: a class representing the current player's hand
* Deck: a class representing a deck of cards. Can draw from the deck
* Card: a class representing a card, with a suit and value
* Suit: an enum with the four suits
* CardValue: an enum with the card values, as well as their names
* InputUtil: a utility class used to gather inputs from the user

By splitting the game as such, it's easy to figure out where to go when to find a bug, as well as where to add something else. For example, adding another player is easy as just adding a new player object and letting them have a turn in the GameState object. Additionally, adding other features, like a double down, can be simply put directly into GameState without much issue.

This game did not require any special data structures, as many are included in the standard library or `java.util`. The main one I used was a simple ArrayList, as it's versatile for both a deck, and a hand. The main algorithm I implemented was a simple greedy algorithm to determine the total of a hand. It adds up all the non aces, and then for each ace, determines whether it can be added and still be under 21.
