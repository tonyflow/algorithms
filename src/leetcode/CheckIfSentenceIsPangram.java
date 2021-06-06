package leetcode;

import java.util.Arrays;

public class CheckIfSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {

        int[] letterCounts = new int[26];
        Arrays.fill(letterCounts,0);

        for (char c : sentence.toCharArray()) {
            letterCounts[c-'a']++;
        }

        for (int letterCount : letterCounts) {
            if (letterCount<1) return false;
        }

        return true;
    }
}
