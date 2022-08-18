package microsoft;

import java.util.Stack;

public class One {

    public int balanceString(String S) {

        /*
        Instead of these 2 variables we could have used an array which would store on
        index i the number of characters we need to remove in the substring(0,1). The solution
         using this array only used the values from dp[i] and dp[i+1] - since the right part of
          the range is exclusive. So I just replaced the array with these two variables.Instead
           of O(n) space we have O(1) - constant - space.
           The runtime complexity is O(S.length) since we have to traverse the full length
           of the input string.
        */
        int currentSubstringRemovals = 0;
        int previousSubstringRemovals = 0;

        char[] r = S.toCharArray();
        int bcount = 0;

        for (int i = 0; i < r.length; i++) {
            if (r[i] == 'A') {
                /*
                If the current character is an 'A' then we have two cases:
                1. After the removals the current state of the string is AAAAA... : So we do not
                need to update the number of removals. We are keepong this a.
                2. After the removals the current state of the string is AA...B... : And now we
                are encoutenring another 'A' so we have two options:
                2.a. Either removing all the B's that we have encountered so far
                2.b. Or remove this one A and keep the number of removals that made the string
                abide by the format in the description.
                */

                currentSubstringRemovals = Math.min(1 + previousSubstringRemovals, bcount);
            } else {
                /*
                We are taking care of the removals when we are encountering an 'A' so in the
                case of 'B' we will just apend the character in the end result.
                */
                currentSubstringRemovals = previousSubstringRemovals;
                bcount++;
            }
            previousSubstringRemovals = currentSubstringRemovals;
        }

        return currentSubstringRemovals;
    }

    public int wordMachine(String S) {
        String[] tokens = S.split(" ");
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                stack.push(number);
            } catch (Exception e) {
                if (token.equals("POP")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        return -1;
                    }
                } else if (token.equals("DUP")) {
                    if (!stack.isEmpty()) {
                        stack.push(stack.peek());
                    } else {
                        return -1;
                    }
                } else if (token.equals("+")) {
                    if (stack.size() > 1) {
                        int topmostNumber = stack.pop();
                        int secondToTopNumber = stack.pop();
                        long additionResult = topmostNumber + secondToTopNumber;
                        if (isValid(additionResult)) {
                            stack.push(Math.addExact(topmostNumber, secondToTopNumber));
                        } else {
                            return -1;
                        }

                    } else return -1;

                } else if (token.equals("-")) {
                    if (stack.size() > 1) {
                        int topmostNumber = stack.pop();
                        int secondToTopNumber = stack.pop();
                        long subtractionResult = topmostNumber - secondToTopNumber;
                        if (isValid(subtractionResult)) {
                            stack.push(Math.subtractExact(topmostNumber, secondToTopNumber));
                        } else {
                            return -1;
                        }
                    } else return -1;
                } else return -1;
            }
        }

        return stack.isEmpty() ? -1 : stack.peek();
    }

    private boolean isValid(long number) {
        if (number >= 0 && number <= Math.pow(2, 20) - 1) return true;
        return false;
    }


    public int solution(int[] A) {
        int current = 0;
        int length = 0;

        // Early stop cases
        if (A.length == 0) return length;
        if (A[0] == -1) return ++length;

        while (A[current] != -1) {
            length++;
            current = A[current];
        }

        return length + 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        // 1048575
        // 2147483647
    }
}
