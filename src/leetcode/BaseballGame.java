package leetcode;

import java.util.Stack;

public class BaseballGame {

    static int calPoints(String[] ops) {

        Stack<Integer> record = new Stack<>();

        for (String op : ops) {
            try {
                int points = Integer.parseInt(op);
                record.push(points);
                continue;
            } catch (Exception e) {
                // ignore
            }

            if (op.equals("C")) {
                if (!record.isEmpty()) {
                    record.pop();
                }
            } else if (op.equals("D")) {
                record.push(record.peek() * 2);
            } else if (op.equals("+")) {
                // Need at least two elements in the record to perform this operation
                if (record.size() > 1) {
                    int tmp = record.peek();
                    record.push(record.get(record.size() - 2) + record.peek());
                }
            } else {
                throw new IllegalArgumentException("No such operation " + op);
            }

        }

        int score = 0;
        while (!record.isEmpty()) {
            score += record.pop();
        }

        return score;
    }

    public static void main(String[] args) {
//        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(calPoints(new String[]{"36", "28", "70", "65", "C", "+", "33", "-46", "84", "C"}));
    }
}
