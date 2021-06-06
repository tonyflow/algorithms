package leetcode;

import java.util.List;

/**
 * The description of this problem does not make any sense...
 */
public class DesignAnOrderedStream {

    class OrderedStream {

        String[] store;

        public OrderedStream(int n) {
            this.store = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            store[idKey] = value;
            return null;
        }
    }
}
