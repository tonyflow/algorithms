package apple;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {

    private Queue<Integer> cards;

    public Deck() {
        this.cards = new LinkedList<>();
    }

    public Deck(Collection<Integer> cards) {
        this.cards = new LinkedList<>(cards);
    }

    public Integer getFromTop() {
        return cards.poll();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Queue<Integer> getCards() {
        return this.cards;
    }
}


