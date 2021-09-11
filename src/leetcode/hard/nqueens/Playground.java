package leetcode.hard.nqueens;

import java.util.List;

public class Playground {

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(6);
        System.out.println(result.size());
        for (List<String> partial : result) {
            for (String row : partial) {
                System.out.println(row);
            }
            System.out.println("==================================================");
        }

    }
}
