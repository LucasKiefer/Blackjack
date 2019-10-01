public class Main {

    public static void main(String[] args) {
        System.out.println("How many chips do you want?");
        int chips = InputUtil.getIntInput(Integer.MAX_VALUE);
        int counter = 1;
        while (chips > 0) {
            System.out.println("ROUND " + counter);
            System.out.println("You have " + chips + " chips.");
            GameState gs = new GameState(chips);
            chips = gs.run();
            counter++;
        }
        System.out.println("You're out of chips. Thanks for playing");
    }
}
