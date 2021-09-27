package leetcode.hard.lfucache;

import java.util.*;

/**
 * Make sure you understand how the min is updated here. All the rest are quite simple.
 */
public class LFUCache {

    /**
     *
     */
    Map<Integer, Integer> keysToValues;

    /**
     *
     */
    Map<Integer, Integer> keysToCounts;

    /**
     * In case of a tie between the counts we need to check which element was least recently used
     */
    Map<Integer, LinkedHashSet<Integer>> countsToLRUKeys;

    /**
     * Overall capacity of the cache
     */
    int capacity;

    int min = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.keysToValues = new HashMap();
        this.keysToCounts = new HashMap();
        this.countsToLRUKeys = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {

        if (this.keysToValues.containsKey(key)) {

            // Get count before update
            int oldCount = this.keysToCounts.get(key);

            // Update keysToCounts
            this.keysToCounts.put(key, oldCount + 1);

            // Update countsToLRUKeys
            // Remove key from the old count group
            this.countsToLRUKeys.get(oldCount).remove(key);

            // Check if the element the get is invoked on was the last element on this specific countsToLRUKeys group
            // Incrementing the min counter by one here makes sense since there are
            // put(1,2), put(1,2), put(1,2), min = 3
            // put(2,3) min = 1
            // get(2) min = 2
            if (this.countsToLRUKeys.get(oldCount).size() == 0 && oldCount == min) min++;

            // Create the new count group if it does not already exist
            this.countsToLRUKeys.putIfAbsent(oldCount + 1, new LinkedHashSet());

            // Add the key to the new count group
            this.countsToLRUKeys.get(oldCount + 1).add(key);

            // Only thing left to do it return the key
            return this.keysToValues.get(key);
        } else return -1;

    }

    public void put(int key, int value) {
        if (this.capacity <= 0) return;

        if (this.keysToValues.containsKey(key)) {
            this.keysToValues.put(key, value);
            // update counts and order of insertion
            // Use the get method for convenience
            get(key);
            return;
        }

        // Exceeds capacity
        if (this.keysToValues.size() == capacity) {
            // Determine which key we should evict

            // This will retrieve the first element added to the LRU list for this count
            Integer keyToBeDeleted = this.countsToLRUKeys.get(min).iterator().next();
            this.countsToLRUKeys.get(min).remove(keyToBeDeleted);
            if (this.countsToLRUKeys.get(min).size() == 0) this.countsToLRUKeys.remove(min);

            // Update keys to values
            this.keysToValues.remove(keyToBeDeleted);

            // Update keys to counts
            this.keysToCounts.remove(keyToBeDeleted);
        }

        // Update keys to values
        this.keysToValues.put(key, value);

        // Update keys to counts
        this.keysToCounts.put(key, 1);

        // Update LRU counts
        this.countsToLRUKeys.putIfAbsent(1, new LinkedHashSet());
        this.countsToLRUKeys.get(1).add(key);

        // Update min
        // Whenever we are adding a new element the minimum should be reset to 1 - there's only one hit on the specific
        // cache element
        min = 1;

    }
}
