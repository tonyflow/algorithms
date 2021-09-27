package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIndexOf = new int[26];
        Arrays.fill(lastIndexOf, -1);

        char[] r = s.toCharArray();

        for (int i = r.length - 1; i >= 0; i--) {
            if (lastIndexOf[r[i] - 'a'] == -1) lastIndexOf[r[i] - 'a'] = i;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < r.length; i++) {
            while (!stack.isEmpty() &&
                    stack.peek() >= r[i] &&
                    !visited[r[i] - 'a'] &&
                    lastIndexOf[stack.peek() - 'a'] > i) {
                Character popped = stack.pop();
                visited[popped - 'a'] = false;
            }

            if (!visited[r[i] - 'a']) {
                stack.push(r[i]);
                visited[r[i] - 'a'] = true;
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }

        return builder.toString();
    }
}
