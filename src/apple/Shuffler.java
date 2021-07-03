package apple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Main shuffling orchestrator. The Shuffler computes the total number of shuffling rounds the given deck of cards
 * has to undergo in order for it to reach the initial ordering.
 */
public class Shuffler {

    /**
     * Collection carrying the original state of the deck upon initialization
     */
    private Queue<Integer> original;

    /**
     * Collection carrying the different intermediate states of the deck as we are
     * walking through the shuffling algorithm
     */
    private Queue<Integer> deck;

    /**
     * Collection carrying the state of the deck as we are progressively placing cards
     * on the table deck
     */
    private Stack<Integer> table;

    /**
     * Create the original deck of cards
     *
     * @param numberOfCards Number of unique cards included in the deck
     * @param inOrder       Set to true if you want an initial ordered state of the elements in the deck
     */
    public Shuffler(int numberOfCards, boolean inOrder) {
        List<Integer> tmp = new LinkedList<>();
        for (int i = 1; i <= numberOfCards; i++) {
            tmp.add(i);
        }
        if (!inOrder) Collections.shuffle(tmp);
        this.original = new LinkedList<>(tmp);
        this.deck = new LinkedList<>(this.original);
        this.table = new Stack<>();
    }

    /**
     * This method evaluates the number of rounds without having to compute all the shuffling rounds' state. Since
     * the shuffling algorithm is deterministic, there is a distinct number of permutations it can produce. The solution
     * is based on the order of permutations and it's actually an implementation of the Wikipedia entry.
     * (https://en.wikipedia.org/wiki/Permutation#Permutation_order)
     * <p>
     * The time complexity of this solution is linear O(n)
     *
     * @return The order coincides with the number of shuffling rounds the deck needs to undergo so that we can reach
     * the initial order. Or in this case, the initial permutation.
     */
    public int order() {

        // Run the spiral shuffle once
        shuffle();

        // Recreate deck-at-hand state from table
        while (!this.table.isEmpty()) {
            this.deck.add(this.table.pop());
        }

        // Find cycles and lengths
        // Create mapping from old to new state
        HashMap<Integer, Integer> originalToPermutation = new HashMap<>();
        while (!this.original.isEmpty() && !this.deck.isEmpty()) {
            originalToPermutation.put(this.original.poll(), this.deck.poll());
        }

        // Identify cycles: If between the old and new state we have mappings like 1 -> 2, 2 -> 4, 4 -> 1, 3 -> 3
        // Then we have the following sets representing cycles (1,2,4) and (3)
        // This is the cyclic notation of a permutation
        Set<Set<Integer>> cycles = new HashSet<>();
        Set<Integer> processed = new HashSet<>();

        for (Map.Entry<Integer, Integer> originalToPermutationState : originalToPermutation.entrySet()) {
            Integer originalState = originalToPermutationState.getKey();
            Integer permutationState = originalToPermutationState.getValue();
            Set<Integer> cycle = new HashSet<>();
            if (!processed.contains(originalState)) {
                processed.add(originalState);
                while (!cycle.contains(permutationState)) {
                    cycle.add(originalState);
                    cycle.add(permutationState);
                    originalState = permutationState;
                    permutationState = originalToPermutation.get(permutationState);
                }
            }
            cycles.add(cycle);
        }

        // Map cycles to cycle lengths
        Set<Integer> cycleLengths = cycles.stream().map(cycle -> cycle.size()).collect(Collectors.toSet());

        // Find least common multiplier of the cycle's lengths
        int leastCommonMultiplier = 1;
        for (Integer cycleLength : cycleLengths) {
            leastCommonMultiplier = lcm(leastCommonMultiplier, cycleLength);
        }

        // Before returning reset state for future iterations of the shuffler
        reset();

        return leastCommonMultiplier;
    }

    /**
     * The simulate method will run the shuffle as many times as it's required for the deck to reach
     * its original order.
     *
     * @return The number of rounds for the deck to return to its original order
     */
    public int simulate() {
        int rounds = 0;
        do {
            shuffle();
            rounds++;

            // Re - initialize state
            // Move all cards from the table to the deck at hand
            while (!this.table.isEmpty()) {
                this.deck.add(this.table.pop());
            }

            // Clear the table off of cards
            this.table.clear();
        } while (!areEqual(this.deck, this.original));

        // Reset the shuffler's state
        reset();

        return rounds;
    }

    /**
     * Reset shuffler's state to the one upon its creation by the constructor
     */
    private void reset() {
        this.deck = new LinkedList<>(this.original);
        this.table = new Stack<>();
    }

    /**
     * Find the least common multiplier
     *
     * @param a First given number
     * @param b Second given number
     * @return Least common multiplier
     */
    private int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        int absHigherNumber = Math.max(absA, absB);
        int absLowerNumber = Math.min(absA, absB);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }

    /**
     * Run one shuffling round. The round ends when we're left with no cards at hand.
     */
    private void shuffle() {
        while (!deck.isEmpty()) {
            // Take the top card off the deck and set it on the table
            table.add(deck.poll());

            // Take the next card off the top and put it on the bottom of the deck in your hand.
            if (!deck.isEmpty()) {
                deck.add(deck.poll());
            } else {
                break;
            }
        }
    }


    /**
     * Based on the LinkedList docs:
     * "Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal.
     * (Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).)
     * In other words, two lists are defined to be equal if they contain the same elements in the same order."
     */
    private boolean areEqual(Queue<Integer> table, Queue<Integer> original) {
        return table.equals(original);
    }

    /**
     * Accessors
     */
    public Queue<Integer> getOriginal() {
        return this.original;
    }
}
