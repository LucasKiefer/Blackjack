import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("How many chips do you want?");
        int chips = InputUtil.getIntInput();
        int counter = 1;
        while (chips > 0) {
            System.out.println("ROUND " + counter);
            System.out.println("You have " + chips + " chips.");
            GameState gs = new GameState(chips);
            chips = gs.run();
            counter++;
        }
        System.out.println("ended main class");
    }
}
