package leetcode;

import java.util.Stack;

/**
 * HARD
 * https://leetcode.com/problems/score-of-parentheses/solution/551761
 */
public class ScoreOfParentheses {

    static int score(String S) {
        Stack<Integer> scoresPerDepth = new Stack<>();
        int score = 0;

        for (char character : S.toCharArray()) {
            if (character == '(') {
                scoresPerDepth.push(score);
                score = 0;
            } else {
                score = scoresPerDepth.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    static int scoreParenthesesAsTree(String S) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < S.toCharArray().length; i++) {
            if (S.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
            }

            // If we find a pair () we multiply one with number two to the power of the depth of the node
            // in the tree of parentheses
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                score += Math.pow(2, depth);
            }
        }

        return score;
    }

    public static void main(String[] args) {
//        System.out.println(score("()"));
//        System.out.println(score("(())"));
//        System.out.println(score("(()(()))"));
//        System.out.println(score("()()"));
//        System.out.println(score("(((())))()"));


        System.out.println(scoreParenthesesAsTree("(()(()))"));
        System.out.println(scoreParenthesesAsTree("()()"));
        System.out.println(scoreParenthesesAsTree("(((())))()"));
    }
}
