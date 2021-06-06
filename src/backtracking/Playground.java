package backtracking;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
//        NQueens nQueens3 = new NQueens(3);
//        nQueens3.solve();

//        NQueens nQueens4 = new NQueens(4);
//        nQueens4.solve();

//        WordBreakProblem wordBreakProblem = new WordBreakProblem();
//        String[] dictionary = new String[]{"a", "cat"};
//        wordBreakProblem.breakInto(dictionary, "abcat");

//        KnightsTour knightsTour = new KnightsTour(6);
//        knightsTour.solve();

        SearchWordInAMatrix searchWordInAMatrix = new SearchWordInAMatrix();
//        char[][] board = new char[][]{
//                {'a', 'b', 'c'},
//                {'g', 'h', 'a'},
//                {'k', 'l', 't'}
//        };
//
        char[][] matrix = {
                { 't', 'z', 'x', 'c', 'd' },
                { 'a', 'h', 'n', 'z', 'x' },
                { 'h', 'w', 'o', 'i', 'o' },
                { 'o', 'r', 'n', 'r', 'n' },
                { 'a', 'b', 'r', 'i', 'n' } };
        searchWordInAMatrix.search(matrix, "horizon");

//        RatInAMazePuzzle ratInAMazePuzzle = new RatInAMazePuzzle();
//        int[][] maze = {
//                {1, 0, 1, 1, 1},
//                {1, 1, 1, 0, 1},
//                {0, 0, 0, 1, 1},
//                {0, 0, 0, 1, 0},
//                {0, 0, 0, 1, 1}
//        };
//
//        ratInAMazePuzzle.escape(maze);

    }
}
