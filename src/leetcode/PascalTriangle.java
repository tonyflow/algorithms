package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PascalTriangle {

    static List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> start = new ArrayList<>();
        start.add(1);
        result.add(start);
        ArrayList<Integer> previous = start;
        for (int i = 0; i < numRows; i++) {
            Stack<Integer> row = new Stack<>();
            row.push(1);
            for (int j = 0; j < previous.size() - 1; j++) {
                row.push(previous.get(j) + previous.get(j + 1));
            }
            row.push(1);
            previous = new ArrayList<>(row);
            result.add(previous);
        }

        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> row : generate(5)) {
            System.out.println(row);
        }
    }

}
