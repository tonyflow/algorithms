package backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreakProblem {

    // ["a","cat"]
    // "acat"
    void breakInto(String[] dictionary, String input) {

        Set<String> ws = Arrays.stream(dictionary).collect(Collectors.toSet());
        String answer = "";
        if (!doBreak(ws, input, "")) {
            System.out.println("Found no solution");
        }
    }

    private boolean doBreak(Set<String> dictionary,
                    String input,
                    String answer) {

        if (input.length() == 0) {
            System.out.println(answer);
            return true;
        } else {
            int index = 0;
            String word = "";
            while (index < input.length()) {
                word += input.charAt(index);
                if (dictionary.contains(word)) {
                    if (doBreak(dictionary, input.substring(index + 1), answer + word + " ")) {
                        return true;
                    } else {
                        System.out.println("Backtracking from word " + word);
                        index++;
                    }
                } else {
                    index++;
                }
            }
        }

        return false;
    }
}
