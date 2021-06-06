package leetcode.allpossiblewordsinaphonenumber;

import java.util.*;

public class AllPossibleWordsInAPhoneNumber {

    private static Map<String, List<String>> digitsToLetters = new HashMap<>();

    static {
        digitsToLetters.put("2", Arrays.asList("a", "b", "c"));
        digitsToLetters.put("3", Arrays.asList("d", "e", "f"));
        digitsToLetters.put("4", Arrays.asList("g", "h", "i"));
        digitsToLetters.put("5", Arrays.asList("j", "k", "l"));
        digitsToLetters.put("6", Arrays.asList("m", "n", "o"));
        digitsToLetters.put("7", Arrays.asList("p", "q", "r", "s"));
        digitsToLetters.put("8", Arrays.asList("t", "u", "v"));
        digitsToLetters.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    private List<String> results = new ArrayList<>();

    List<String> find(String number) {

        if (!number.isEmpty()) {
            doFind(number, "", 0);
        }

        return results;

    }

    private void doFind(String number,
                        String word,
                        int index) {
        if (word.length() == number.length()) {
            results.add(word);
            return;
        }

        if (word.length() < number.length()) {
            for (String character : digitsToLetters.get(Character.toString(number.charAt(index)))) {
                doFind(number, word + character, index + 1);
            }
        }
    }
}
