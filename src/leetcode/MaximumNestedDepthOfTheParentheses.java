package leetcode;

public class MaximumNestedDepthOfTheParentheses {

    public int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') depth++;
            else if(c == ')') depth--;
            else continue;

            maxDepth = Math.max(maxDepth,depth);
        }

        return maxDepth;
    }
}
