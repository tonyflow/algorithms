package apple;

/**
 * Entry point for the shuffler application. It requires a valid integer to start processing
 */
public class ShufflerApp {

    public static void main(String[] args) {
        int numberOfCards = Integer.parseInt(args[0]);
        Shuffler shuffler = new Shuffler(numberOfCards, false);
//        System.out.println("Number of rounds to reach original state for " + numberOfCards + " cards using simulation is " + shuffler.simulate());
        System.out.println("Number of rounds to reach original state for " + numberOfCards + " cards using permutation order is " + shuffler.order());
    }
}
