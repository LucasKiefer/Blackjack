import java.util.Scanner;

public class InputUtil {
    public static int getIntInput() {
        Scanner input = new Scanner(System.in);
        boolean inputChecker = false;
        while (true) {
            try {
                String chipsString = input.nextLine();
                int chips = Integer.parseInt(chipsString);
                if (chips <= 0) {
                    throw new IllegalArgumentException();
                }
                return chips;
            }
            catch(java.lang.NumberFormatException e) {
                System.out.println("That's not an integer! Try an actual integer.");
            }
            catch(IllegalArgumentException e) {
                System.out.println("That's not positive! Try a positive number");
            }
        }
    }
    //Returns true if the value is a hit and false if it's a pass
    public static boolean getHitInput() {
        Scanner input = new Scanner(System.in);
        boolean inputChecker = false;
        while (true) {
                String string = input.nextLine();
                string.replaceAll("\\s+","");
                string.toLowerCase();
                if (string.equals("hit")) {
                    return true;
                } else if (string.equals("pass")) {
                    return false;
                }
                System.out.println("Please type hit or pass.");
        }
    }
}
