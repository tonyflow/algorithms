package leetcode.easy;

public class DIStringMatch {

    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int start = 0;
        int end = s.length();
        for (int i = 0; i < result.length - 1; i++) {
            if (s.charAt(i) == 'I') result[i] = start++;
            if (s.charAt(i) == 'D') result[i] = end--;
        }

        result[result.length - 1] = s.charAt(s.length() - 1) == 'I' ? end : start;
        return result;
    }
}
