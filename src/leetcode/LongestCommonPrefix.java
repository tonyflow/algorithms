package leetcode;

public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {
        // Find the smallest string
        int minLength = Integer.MAX_VALUE;
        String minString = "";
        for (String str : strs) {
            if (str.length() < minLength) {
                minString = str;
                minLength = str.length();
            }
        }


        while (!minString.isEmpty()) {
            boolean found = true;
            for (String str : strs) {
                String prefix = str.substring(0, minLength);
                if (!prefix.equals(minString)) {
                    minString = minString.substring(0, minString.length() - 1);
                    minLength--;
                    found = false;
                    break;
                }
            }

            if (found) break;
        }


        return minString;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
