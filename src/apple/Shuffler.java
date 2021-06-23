package apple;

import java.util.*;

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
     * Counter used to identify the number of rounds needed so that the table deck to
     * be equal - in order - with the original deck of cards
     */
    private int rounds = 0;

    /**
     * Create the original deck of cards
     *
     * @param numberOfCards Number of unique cards included in the deck
     * @param inOrder       set to true if you want an initial ordered state of the elements in the deck
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
        this.rounds = 0;
    }

    public void shuffle() {
        do {
            while (!deck.isEmpty()) {
                // Take the top card off the deck and set it on the table
                table.add(deck.poll());

                // Take the next card off the top and put it on the bottom of the deck in your hand.
                if (!deck.isEmpty()) {
                    deck.add(deck.poll());
                } else {
                    break;
                }
//                System.out.println("Deck after iteration " + deck);
//                System.out.println("Table after iteration " + table);
            }
            this.rounds++;

            // Re - initialize state
            // Move all cards from the table to the deck at hand
            while (!this.table.isEmpty()){
                this.deck.add(this.table.pop());
            }
            System.out.println("Reloaded deck from table state after " + rounds + " round: " + deck);

            // Clear the table off of cards
            this.table.clear();
        } while (!areEqual(this.deck, this.original));
    }

    private boolean areEqual(Queue<Integer> table, Queue<Integer> original) {
        return table.equals(original);
    }


    /**
     * Accessors
     */
    public int getRounds() {
        return this.rounds;
    }

    public Queue<Integer> getOriginal() {
        return this.original;
    }
}
