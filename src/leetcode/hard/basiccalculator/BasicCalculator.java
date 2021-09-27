package leetcode.hard.basiccalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int number = 0;
        int result = 0;
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result); // store intermediate result
                stack.push(sign); // store sign
                result = 0;
                // an opening parenthesis can only be preceded by a sign so the following reset could be omitted
//                number = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // at the top of the stack we have the sign
                result += stack.pop(); // right under the top we have the result of the previous expression
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }

    public int itsthesamecomplexityinthened(String s) {
        Stack<String> stack = new Stack();
        int total = 0;
        char[] r = s.toCharArray();
        int i = 0;
        while (i < r.length) {
            // parse integer
            if (Character.isDigit(r[i])) {
                // parse number
                int helper = i;
                StringBuilder builder = new StringBuilder();
                while (helper < r.length && Character.isDigit(r[helper])) {
                    builder.append(r[helper++]);
                }

                stack.push(builder.toString());
                i = helper;
            } else if (r[i] == '+' || r[i] == '-' || r[i] == '-' || r[i] == '(') stack.push(String.valueOf(r[i++]));
            else if (r[i] == ' ') i++; // ignore white space
            else {
                // c == ')' closing parenthesis so start evaluating the enclosed expression
                int res = 0;
                int previousDigit = 0;
                String operator = "+";
                while (!stack.peek().equals("(")) {
                    String popped = stack.pop();
                    if (popped.matches("[-]*[0-9]+")) {
                        previousDigit = Integer.parseInt(popped);
                    } else if (popped.equals("+") || popped.equals("-")) {
                        res = popped.equals("+") ? res + previousDigit : res + (-1) * previousDigit;
                        previousDigit = 0;
                    }
                }

                res += previousDigit;

                // pop opening parenthesis
                stack.pop();

                // push evaluated expression
                stack.push(Integer.toString(res));

                i++;
            }
        }

        // After this point we have no parentheses in the expression
        int previousDigit = 0;
        String operator = "+";
        while (!stack.isEmpty()) {
            String popped = stack.pop();
            if (popped.matches("[-]*[0-9]+")) {
                previousDigit = Integer.parseInt(popped);
                operator = "";
            } else if (popped.equals("+") || popped.equals("-")) {
                total = popped.equals("+") ? total + previousDigit : total + (-1) * previousDigit;
                operator = popped;
            }
        }

        return operator.isEmpty() ? total + previousDigit : total;
    }

    public int worksButYouCanDoBetter(String s) {
        return doCalculate(s, 0, s.length() - 1);
    }

    private int doCalculate(String s, int start, int end) {
//        if (start == end) return s.charAt(start);

        int res = 0;
        char operator = '+';
        while (start <= end) {

            // Ignore white spaces
            while (start <= end && s.charAt(start) == ' ') start++;

            // Search for operators
            if (start <= end && s.charAt(start) == '+') {
                operator = '+';
                start++;
            } else if (start <= end && s.charAt(start) == '-') {
                operator = '-';
                start++;
            }

            // Ignore white spaces
            while (start <= end && s.charAt(start) == ' ') start++;

            // Search for numbers or expressions
            StringBuilder builder = new StringBuilder();
            int evaluatedExpression = 0;
            if (start <= end && (s.charAt(start) >= '0' && s.charAt(start) <= '9')) {
                // Search for numbers
                while (start <= end && (s.charAt(start) >= '0' && s.charAt(start) <= '9'))
                    // construct number
                    builder.append(s.charAt(start++));
                evaluatedExpression = Integer.parseInt(builder.toString());
            } else if (start <= end && s.charAt(start) == '(') {

                // Search for expressions
                // Start and end of parenthesized expression
                int startOfExpression = start + 1; // ignore starting parenthesis
                int endOfExpression;

                // Find valid parenthesized expression
                Stack<Character> stack = new Stack();
                stack.push(s.charAt(start++));

                while (start <= end && !stack.isEmpty()) {
                    if (s.charAt(start) == '(') stack.push(s.charAt(start));
                    else if ((s.charAt(start) == ')')) stack.pop();
                    start++;
                }
                endOfExpression = start - 2; // (4+5) - when the loop exists start = 5 and end = 3
                evaluatedExpression = doCalculate(s, startOfExpression, endOfExpression);
            }

            if (operator == '+') res += evaluatedExpression;
            else if (operator == '-') res -= evaluatedExpression;
        }

        return res;
    }

    public int pileOfShit(String s) {
        char[] r = s.toCharArray();
        int res = 0;
        int i = 0;
        List<String> clean = new ArrayList();
        while (i < r.length) {
            while (i < r.length && (r[i] == '(' || r[i] == ')' || r[i] == ' ')) i++;

            StringBuilder builder = new StringBuilder();
            while (i < r.length && (r[i] >= '0' && r[i] <= '9'))
                // construct number
                builder.append(r[i++]);

            // add number to cleaned representation
            if (builder.length() > 0) clean.add(builder.toString());

            // add operator to clean representation
            if (i < r.length && (r[i] == '+' || r[i] == '-'))
                clean.add(String.valueOf(r[i++]));
        }

        i = 0;
        String operator;

        System.out.println(clean);

        // Evaluation loop
        while (i < clean.size()) {
            StringBuilder builder = new StringBuilder();
            while (i < clean.size() && (clean.get(i).equals("+") || clean.get(i).equals("-")))
                builder.append(clean.get(i++));

            if (builder.length() > 1) operator = "-";
            else operator = builder.toString();

            if (i < clean.size()) {
                if (operator.equals("+") || operator.isEmpty()) res += Integer.parseInt(clean.get(i++));
                else res -= Integer.parseInt(clean.get(i++));
            }
        }
        return res;
    }
}
