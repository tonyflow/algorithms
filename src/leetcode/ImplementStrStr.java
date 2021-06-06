package leetcode;

public class ImplementStrStr {

    static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return 0;

        int start = 0;
        int end = needle.length();
        while (end < haystack.length() + 1) {
            if (haystack.substring(start, end).equals(needle)) return start;
            start++;
            end++;
        }

        return 0;
    }

    /**
     * Without using built in functions (m*n)
     */
    static int usingCharComparison(String h, String n) {
        for (int i = 0; i < h.length(); i++) {
            boolean found = true;
            for (int j = 0, k = i; j < n.length() && found && k < h.length(); j++, k++) {
                if (h.charAt(i) != n.charAt(j)) found = false;
            }
            if (found) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(strStr("a", "a"));
        System.out.println(usingCharComparison("a", "a"));
        System.out.println(usingCharComparison("hello", "ll"));
    }
}
