package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        permute(s, 0, result);
        return result;
    }

    private void permute(String s,
                         int index,
                         ArrayList<String> result) {
        if (index == s.length()) result.add(s);
        else {
            char current = s.charAt(index);
            if (current >= 'a' && current <= 'z') {
                StringBuilder builder = new StringBuilder(s);
                builder.setCharAt(index, (char) (current - 32));
                permute(builder.toString(), index + 1, result);
            }

            if (current >= 'A' && current <= 'Z') {
                StringBuilder builder = new StringBuilder(s);
                builder.setCharAt(index, (char) (current + 32));
                permute(builder.toString(), index + 1, result);
            }

            // Leave string unchanged
            permute(s, index + 1, result);
        }
    }
}
