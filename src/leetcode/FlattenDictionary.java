package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        return doFlatten("", dict);
    }

    private static HashMap<String, String> doFlatten(String flattenedKey, Map<String, Object> abstractValue) {

        HashMap<String, String> result = new HashMap<>();

        for (Map.Entry<String, Object> entry : abstractValue.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            String customKey = flattenedKey.isEmpty() ? key : flattenedKey + "." + key;
            if (value instanceof Map) {
                Map<String, String> flattened = doFlatten(customKey, (Map<String, Object>) value);
                // Merge flattened to result
                for (Map.Entry<String, String> flattenedEntry : flattened.entrySet()) {
                    String flattenedEntryKey = flattenedEntry.getKey();
                    String flattenedEntryValue = flattenedEntry.getValue();
                    result.put(flattenedEntryKey, flattenedEntryValue);
                }
            } else {
                result.put(customKey, (String) value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Object> c = new HashMap<>();
        c.put("c", 1);
        Map<String, Object> b = new HashMap<>();
        b.put("b", "something");
        b.put("b2", c);

        HashMap<String, Object> a = new HashMap<>();
        a.put("a", "something");
        a.put("a2", b);

        HashMap<String, String> result = flattenDictionary(a);

        for (Map.Entry<String, String> stringStringEntry : result.entrySet()) {
            System.out.println(stringStringEntry.getKey() + "  " + stringStringEntry.getValue());
        }

    }
}
