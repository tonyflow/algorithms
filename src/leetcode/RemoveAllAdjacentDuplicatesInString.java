package leetcode;

import java.io.CharArrayReader;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    static String removeDuplicates(String S) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.add(c);
            }

        }
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
