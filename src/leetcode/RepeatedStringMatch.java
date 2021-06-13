package leetcode;

import java.util.Arrays;

public class RepeatedStringMatch {

    static public int repeatedStringMatch2(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            int indexA = i;
            int indexB = b.indexOf(a);
            int checkedChars = 0;
            boolean canBe = true;
            int repetitions = 0;

            if (indexB != -1) {
                while (checkedChars < b.length() && canBe) {
                    if (a.charAt(indexA) != b.charAt(indexB)) canBe = false;
                    else {
                        indexA = (indexA + 1) % a.length();
                        indexB = (indexB + 1) % b.length();
                        checkedChars++;
                        if (indexA == 0 || indexB == 0) repetitions++;
                    }
                }
                if (canBe && checkedChars == b.length()) return repetitions;
            }


        }
        return -1;
    }

    static public int repeatedStringMatch(String a, String b) {
        StringBuilder builder = new StringBuilder(a);
        int count = 1;
        while (builder.length() < b.length()) {
            builder.append(a);
            count++;
        }
        if (builder.indexOf(b) != -1) return count;
        if (builder.append(a).indexOf(b) != 1) return ++count;
        return -1;
    }

    public static void main(String[] args) {
        repeatedStringMatch2("abcd", "cdabcdab");

    }
}
