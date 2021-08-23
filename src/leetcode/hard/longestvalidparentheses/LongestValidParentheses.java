package leetcode.hard.longestvalidparentheses;

import java.util.*;

public class LongestValidParentheses {

    class Pair {
        char c;
        int index;

        public Pair(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    class ValidSubstring {
        int start;
        int end;

        public ValidSubstring(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int getStart() {
            return this.start;
        }

        public ValidSubstring clone() {
            return new ValidSubstring(this.start, this.end);
        }
    }

    public int longestValidParentheses(String s) {
        Stack<Pair> stack = new Stack();
        List<ValidSubstring> valid = new ArrayList<>();
        List<ValidSubstring> result = new ArrayList<>();


        char[] r = s.toCharArray();

        for (int i = 0; i < r.length; i++) {
            if (stack.isEmpty()) stack.push(new Pair(r[i], i));
            else if (r[i] == ')' && stack.peek().c == '(') {
                Pair popped = stack.pop();
                valid.add(new ValidSubstring(popped.index, i));
            } else stack.push(new Pair(r[i], i));
        }

        // We do not care about what is left in the array
        // We want to merge the intervals of the valid list
        if (valid.isEmpty()) return 0;
        Collections.sort(valid, Comparator.comparing(ValidSubstring::getStart));
        ValidSubstring reference = valid.get(0);
        for (ValidSubstring vs : valid) {
            if (vs.start < reference.end || vs.start == reference.end + 1) {
                reference.end = Math.max(vs.end, reference.end);
            } else if (vs.start > reference.end + 1) {
                result.add(reference.clone());
                reference = vs;
            }
        }

        result.add(reference);

        int max = Integer.MIN_VALUE;
        for (ValidSubstring vs : result)
            max = Math.max(max, vs.end - vs.start + 1);

        return max;
    }

    /**
     * Brute force. Works but TLEs
     */
    public int brute(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack();
            stack.push(s.charAt(i));
            int current = i + 1;
            while (current < s.length()) {
                if (stack.isEmpty()) stack.push(s.charAt(current));
                else if (s.charAt(current) == ')' && stack.peek() == '(') stack.pop();
                else stack.push(s.charAt(current));

                // this is a valid substring so
                if (stack.isEmpty()) max = Math.max(max, current - i + 1);
                current++;
            }
        }

        return max;
    }

    /**
     * Two things to pay attention here:
     * - Add -1 to the stack in the beginning
     * - When we encounter a ')' and we have to pop an element (index) from the stack, then for the
     * calculation of the length we use the current TOP element on the list NOT the popped one!
     */
    public int stack(String s) {
        if (s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack();
        char[] r = s.toCharArray();

        int max = Integer.MIN_VALUE;
        stack.push(-1);
        for (int i = 0; i < r.length; i++) {
            if (r[i] == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
