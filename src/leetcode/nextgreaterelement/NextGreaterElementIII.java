package leetcode.nextgreaterelement;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NextGreaterElementIII {

    // Time Limit Exceeded
    int nextGreaterNumber(int n) {
        String number = Integer.toString(n);
        ArrayList<Integer> results = new ArrayList<>();
        findPermutations("", number, n, results);
        return results.isEmpty() ? -1 : results.stream().sorted().collect(Collectors.toList()).get(0);
    }

    int nextPermutation(int n) {
        String number = Integer.toString(n);
        char[] numberChars = number.toCharArray();
        for (int i = numberChars.length - 1; i >= 1; i--) {
            // Decreasing order from the end
            if (number.charAt(i) > number.charAt(i - 1)) {
                char pivotElement = number.charAt(i - 1);
                // Find element greater than pivotElement
                // All elements from i to the end of the array are in descending order (number.charAt(i) < number.charAt(i - 1))
                // but we're inside this  if (number.charAt(i) > number.charAt(i - 1)) so by finding the element in this
                // ascending sequence that is less than the pivot element then the element just before that will be the
                // next greater than the pivot.
                int nextGreaterIndex = i;
                for (int j = numberChars.length-1; j >= i; j--) {
                    if (numberChars[j] > pivotElement) {
                        nextGreaterIndex = j;
                        break;
                    }
                }

                // Swap nextGreaterIndex and i-1
                swap(numberChars, nextGreaterIndex, i - 1);

                // Reverse elements from i to n - Since i to n is increasing
                // so when we reverse them the sequence is going to be decreasing
                int start = i;
                int end = numberChars.length - 1;
                while (start <= end) {
                    swap(numberChars, start, end);
                    start++;
                    end--;
                }

                // Char array to string
                try {
                    return Integer.parseInt(String.valueOf(numberChars));
                } catch (Exception e) {
                    return -1;
                }
            }
        }
        return -1;
    }

    private void swap(char[] numberChars, int i, int j) {
        char tmp = numberChars[i];
        numberChars[i] = numberChars[j];
        numberChars[j] = tmp;
    }

    // Not used
    private int swap(String number, int a, int b) {
        StringBuilder stringBuilder = new StringBuilder(number);
        char charAtA = number.charAt(a);
        char charAtB = number.charAt(b);
        stringBuilder.replace(a, a + 1, Character.toString(charAtB));
        stringBuilder.replace(b, b + 1, Character.toString(charAtA));
        return Integer.parseInt(stringBuilder.toString());
    }

    // Too slow for this solution
    private void findPermutations(String perm,
                                  String remainingNumber,
                                  Integer min,
                                  ArrayList<Integer> results) {
        if (remainingNumber.length() == 0) {
            try {
                int candidate = Integer.parseInt(perm);
                if (candidate > min) {
                    results.add(candidate);
                }
            } catch (NumberFormatException e) {
                // ignore
            }
        } else {
            for (int i = 0; i < remainingNumber.toCharArray().length; i++) {
                findPermutations(perm + remainingNumber.charAt(i),
                        remainingNumber.substring(0, i) + remainingNumber.substring(i + 1),
                        min,
                        results);
            }
        }

    }


}
