package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> memo = new HashMap<>();
        return accumulate(0, 0, 0, triangle, memo);
//        return accumulateNoMemo(0, 0, 0, triangle);
    }

    private int accumulate(Integer sum,
                           int row,
                           int column,
                           List<List<Integer>> triangle,
                           Map<String, Integer> memo) {
        if (row < triangle.size() && column < triangle.get(row).size()) {
            String key = row + "_" + column;
            if (!memo.containsKey(key)) {
                memo.put(
                        key,
                        Math.min(
                                accumulate(triangle.get(row).get(column), row + 1, column, triangle, memo),
                                accumulate(triangle.get(row).get(column), row + 1, column + 1, triangle, memo)
                        )
                );
            }
            return sum + memo.get(key);
        } else {
            return sum;
        }
    }

    private int accumulateNoMemo(Integer sum,
                                 int row,
                                 int column,
                                 List<List<Integer>> triangle) {
        if (row < triangle.size() && column < triangle.get(row).size()) {
            int sameColumn = accumulateNoMemo(sum + triangle.get(row).get(column), row + 1, column, triangle);
            int columnPlusOne = accumulateNoMemo(sum + triangle.get(row).get(column), row + 1, column + 1, triangle);
            System.out.println("row=" + row + ",column=" + column);
            System.out.println("Same column " + sameColumn);
            System.out.println("Column plus one " + columnPlusOne);
            return Math.min(sameColumn, columnPlusOne);
        } else {
            return sum;
        }
    }


}
