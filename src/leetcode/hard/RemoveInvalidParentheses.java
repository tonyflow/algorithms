package leetcode.hard;

import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        TreeMap<Integer, Set<String>> result = new TreeMap<>();
        traverse(s, 0, new Stack<>(), new StringBuilder(), result);
        return new ArrayList<>(result.firstEntry().getValue());
    }

    private void traverse(String s,
                          int index,
                          Stack<Character> stack,
                          StringBuilder builder,
                          TreeMap<Integer, Set<String>> result) {
        if (index == s.length() && stack.isEmpty()) {
            int charactersRemoved = s.length() - builder.length();
            if (result.containsKey(charactersRemoved)) {
                Set<String> update = result.get(charactersRemoved);
                update.add(builder.toString());
                result.put(charactersRemoved, update);
            } else {
                Set<String> partial = new HashSet<>();
                partial.add(builder.toString());
                result.put(charactersRemoved, partial);
            }
        }

        if (index < s.length()) {

            // Continue with traversal
            char current = s.charAt(index);
            if (current >= 'a' && current <= 'z') {
                builder.append(current);
                traverse(s, index + 1, stack, builder, result);

                // backtrack
                builder.deleteCharAt(builder.length() - 1);
            }

            // ( or )
            if (current == ')') {

                // do not take it
                traverse(s, index + 1, stack, builder, result);

                // take it
                if (!stack.isEmpty() && stack.peek() == '(') {
                    Character popped = stack.pop();
                    builder.append(current);
                    traverse(s, index + 1, stack, builder, result);

                    // backtrack
                    builder.deleteCharAt(builder.length() - 1);
                    stack.push(popped);
                }
            }

            if (current == '(') {

                // do not take it
                traverse(s, index + 1, stack, builder, result);

                // take it
                stack.push(current);
                builder.append(current);
                traverse(s, index + 1, stack, builder, result);

                // backtrack
                stack.pop();
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
