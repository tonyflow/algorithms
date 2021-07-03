package apple;

import java.util.function.Supplier;

/**
 * Entry point for the shuffler application. It requires a valid integer to start processing.
 * Due to the time complexity of the simulation method for inputs greater than 186 this approach is commented out.
 * The app uses the permutation order approach.
 */
public class ShufflerApp {

    public static void main(String[] args) {
        int numberOfCards = Integer.parseInt(args[0]);
        Shuffler shuffler = new Shuffler(numberOfCards, false);
        Supplier<Integer> shufflerRun = () -> shuffler.order();
//        Supplier<Integer> shufflerRun = () -> shuffler.simulate();
        Result result = time(shufflerRun);
        System.out.println("Number of rounds to reach original state for " + numberOfCards + " cards is " + result.rounds + ". Took " + result.time + " ms");
    }

    /**
     * Generic operations timer
     *
     * @param f The operation you want to time
     * @return The time in ms it takes for the operation to complete.
     */
    static Result time(Supplier<Integer> f) {
        long start = System.currentTimeMillis();
        int rounds = f.get();
        long end = System.currentTimeMillis();
        return new Result(end - start, rounds);
    }

    /**
     * Shuffling results carrying utility class
     */
    static class Result {
        long time;
        int rounds;

        public Result(long time, int rounds) {
            this.time = time;
            this.rounds = rounds;
        }
    }
}
