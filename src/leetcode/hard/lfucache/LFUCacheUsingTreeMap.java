package leetcode.hard.lfucache;

import java.util.*;

/**
 * This implementation uses a TreeMap and a tree map's operations have logn complexity
 */
public class LFUCacheUsingTreeMap {

    class CacheKey {
        private int counter;
        private long timestamp;
        private int value;

        public CacheKey(int counter, long timestamp, int value) {
            this.counter = counter;
            this.timestamp = timestamp;
            this.value = value;
        }

        long getTimestamp() {
            return this.timestamp;
        }

        int getCounter() {
            return this.counter;
        }

        void incrementCounter() {
            this.counter++;
        }

        void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        void setValue(int value) {
            this.value = value;
        }

        public boolean equals(Object o) {
            CacheKey other = (CacheKey) o;
            return other.counter == this.counter && other.timestamp == this.timestamp && this.value == other.value;
        }

        public int hashCode() {
            return Objects.hash(this.counter, this.timestamp, this.value);
        }

        @Override
        public String toString() {
            return "CacheKey{" +
                    "counter=" + counter +
                    ", timestamp=" + timestamp +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * Map from cache key to its corresponding key
     */
    TreeMap<CacheKey, Integer> timeKeeper;

    /**
     * Map from keys to the keys of th timekeeper map
     */
    Map<Integer, CacheKey> cache;

    /**
     * Total capacity of the cache
     */
    int capacity;

    /**
     * Compare first on the least frequently used, so we are keeping the elements of the cache with the smallest
     * counters in the first entries of the tree map.
     * <p>
     * In case of a tie we have to evict the least recently used, so we are using the timestamp entry, and we are keeping
     * the ones with the smaller
     */
    public LFUCacheUsingTreeMap(int capacity) {

        this.timeKeeper = new TreeMap(Comparator.comparingInt(CacheKey::getCounter).thenComparingLong(CacheKey::getTimestamp));
        this.cache = new HashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            CacheKey searchKey = this.cache.get(key);

            // We have to remove the old entry from the timekeeper map and re add it to the tree map
            // since if we update only the reference the sorting will not take place again
            this.timeKeeper.remove(searchKey);

            // Update the entry in the timekeeper map with an updated counter and a new last used timestamp
            searchKey.incrementCounter();
            searchKey.setTimestamp(System.nanoTime());
            this.timeKeeper.put(searchKey, key);
            return this.cache.get(key).value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (this.capacity > 0) {
            // Check if we have to remove something from the map
            if (this.cache.size() == this.capacity && !this.cache.containsKey(key)) {

                // Remove the least frequently used OR - in case of a tie - least recently used element
                Map.Entry<CacheKey, Integer> lfuEntry = this.timeKeeper.pollFirstEntry();
                CacheKey lfuKey = lfuEntry.getKey();
                Integer lfuValue = lfuEntry.getValue();

                // Remove elements from both cache and timekeeper
                this.timeKeeper.remove(lfuKey);
                this.cache.remove(lfuValue);
            }

            // Check if it is present
            if (this.cache.containsKey(key)) {
                CacheKey searchKey = this.cache.get(key);

                // Remove the old entry from the timekeeper map. Again here we remove the old entry from the timekeeper map
                // and re add it to the tree map since if we update only the reference the sorting will not take place
                this.timeKeeper.remove(searchKey);

                // Update the entry in the timekeeper map with an updated counter and a new last used timestamp
                searchKey.incrementCounter();
                searchKey.setTimestamp(System.nanoTime());
                searchKey.setValue(value);

                this.timeKeeper.put(searchKey, key);
                this.cache.put(key, searchKey);

            } else {
                // Now add the new element
                doPut(key, value);
            }
        }
    }

    private void doPut(int key, int value) {
        CacheKey cacheKey = new CacheKey(1, System.nanoTime(), value);
        this.timeKeeper.put(cacheKey, key);
        this.cache.put(key, cacheKey);
    }
}
