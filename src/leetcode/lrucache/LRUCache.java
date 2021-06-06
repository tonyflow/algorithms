package leetcode.lrucache;

import java.util.*;

public class LRUCache {
    int capacity;
    Map<Integer, List<Info>> countToInfo;
    Map<Integer, Integer> cache;

    class Info {
        int key;
        long lastUpdated;

        public Info(int key, long lastUpdated) {
            this.key = key;
            this.lastUpdated = lastUpdated;
        }
    }


    public LRUCache(int capacity) {
        this.countToInfo = new HashMap<>();
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }
}
