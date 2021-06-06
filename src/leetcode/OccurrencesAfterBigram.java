package leetcode;

import java.util.ArrayList;

public class OccurrencesAfterBigram {

    static String[] findOcurrences(String text,
                                   String first,
                                   String second) {

        String[] split = text.split(" ");
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0, j = 1; i <= split.length - 3 && j <= split.length - 2; i++,j++) {
            if (first.equals(split[i]) && second.equals(split[j])) {
                result.add(split[j + 1]);
            }
        }

        return result.toArray(new String[result.size()]);

    }

    public static void main(String[] args) {
        findOcurrences("alice is a good girl she is a good student","a","good");
    }
}
