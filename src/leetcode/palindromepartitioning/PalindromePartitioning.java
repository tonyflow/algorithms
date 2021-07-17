package leetcode.palindromepartitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        build(s, new LinkedList<>(), result);
        return result;
    }

    private void build(String remaining,
                       LinkedList<String> partial,
                       List<List<String>> result) {
        if (remaining.length() == 1) {
            partial.add(remaining);
            result.add(new ArrayList<>(partial));
            partial.removeLast();
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                String prefix = remaining.substring(0, i);
                String suffix = remaining.substring(i);
                if (isPalindrome(prefix)) {
                    partial.add(prefix);
                    build(suffix, partial, result);
                    partial.removeLast();
                }
                if (prefix.isEmpty() && isPalindrome(suffix)) {
                    partial.add(remaining);
                    result.add(new ArrayList<>(partial));
                    partial.removeLast();
                }
            }
        }
    }

    private boolean isPalindrome(String prefix) {
        if (prefix.isEmpty()) return false;
        int start = 0;
        int end = prefix.length() - 1;
        while (start < end) {
            if (prefix.charAt(start) != prefix.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
