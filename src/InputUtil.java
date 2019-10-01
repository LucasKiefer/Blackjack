import java.util.Scanner;

public class InputUtil {
    public static int getIntInput(int maximum) {
        Scanner input = new Scanner(System.in);
        boolean inputChecker = false;
        while (true) {
            try {
                String chipsString = input.nextLine();
                int chips = Integer.parseInt(chipsString);
                if (chips <= 0) {
                    throw new IllegalArgumentException("That's not positive! Try a positive number.");
                } else if (chips > maximum) {
                    throw new IllegalArgumentException("That's too big! Try a smaller number.");
                }
                return chips;
            }
            catch(java.lang.NumberFormatException e) {
                System.out.println("That's not an integer! Try an actual integer.");
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //Returns true if the value is a hit and false if it's a stand
    public static boolean getHitInput() {
        Scanner input = new Scanner(System.in);
        boolean inputChecker = false;
        while (true) {
                String string = input.nextLine();
                string.replaceAll("\\s+","");
                string.toLowerCase();
                if (string.equals("hit")) {
                    return true;
                } else if (string.equals("stand")) {
                    return false;
                }
                System.out.println("Please type hit or stand.");
        }
    }
}
